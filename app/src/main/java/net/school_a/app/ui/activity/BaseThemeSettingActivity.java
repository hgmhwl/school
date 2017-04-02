package net.school_a.app.ui.activity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.jude.utils.JUtils;

import net.school_a.app.R;
import net.school_a.app.model.bean.PrintData;
import net.school_a.app.utils.BluetoothUtil;
import net.school_a.app.utils.ESCUtil;

import java.io.IOException;

import okhttp3.MediaType;

/**
 * author：anumbrella
 * Date:16/9/5 上午10:00
 */
public class BaseThemeSettingActivity extends AppCompatActivity {
    public static final MediaType MYJSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomTheme();
    }


    private void setCustomTheme() {
        int theme = JUtils.getSharedPreference().getInt("THEME", 0);
        switch (theme) {
            case 1:
                setTheme(R.style.AppTheme1);
                break;
            case 2:
                setTheme(R.style.AppTheme2);
                break;
            case 3:
                setTheme(R.style.AppTheme3);
                break;
            case 4:
                setTheme(R.style.AppTheme4);
                break;
            case 5:
                setTheme(R.style.AppTheme5);
                break;
            default:
                setTheme(R.style.AppThemeDefault);
                break;
        }
    }

    /////////////////////////////////////////////////////////
    /////////////////////小票打印实现/////////////////////////
    ////////////////////////////////////////////////////////
    public void doPrint(PrintData printData) {
        // 1: 检测是否打开蓝牙设备
        BluetoothAdapter btAdapter = BluetoothUtil.getBTAdapter();
        if (btAdapter == null) {
            Toast.makeText(getBaseContext(), "请打开蓝牙", Toast.LENGTH_SHORT).show();
            return;
        }
        // 2: 检测蓝牙是否配对
        BluetoothDevice device = BluetoothUtil.getDevice(btAdapter);
        if (device == null) {
            Toast.makeText(getBaseContext(), "请将蓝牙设备配对!", Toast.LENGTH_SHORT).show();
            return;
        }
        // 3: 拼接打印的数据
        byte[] data = ESCUtil.generateTiketData(printData);
        BluetoothSocket socket = null;
        try {
            socket = BluetoothUtil.getSocket(device);
            BluetoothUtil.sendData(data, socket);
        } catch (IOException e) {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
