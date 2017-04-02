package net.school_a.app.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jude.utils.JUtils;

import net.school_a.app.R;
import net.school_a.app.utils.BaseUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mac on 2017/3/13.
 * 添加供应商
 */

public class AddSupplierActivity extends BaseThemeSettingActivity {
    @BindView(R.id.order_all_toolbar)
    Toolbar toolbar;
    @BindView(R.id.text_title)
    TextView tv_Title;
    @BindView(R.id.supplier_add_more)
    LinearLayout ll_More;
    @BindView(R.id.supplier_add_cuk)
    LinearLayout ll_Cuk;
    @BindView(R.id.supplier_add_return)
    LinearLayout ll_Return;
    @BindView(R.id.supplier_img_add)
    ImageView headImage;
    Dialog dialog;
    private static final int PHOTO_REQUEST_CAMERA = 1;// 拍照

    private static final int PHOTO_REQUEST_GALLERY = 2;// 从相册中选择

    private static final int PHOTO_REQUEST_CUT = 3;// 结果

    private static final String PHOTO_FILE_NAME = "temp_photo.jpg";

    private Bitmap bitmap;

    private File tempFile;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_supplier);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        toolbar.setTitle("");
        tv_Title.setText("添加供应商");
        setToolbar(toolbar);
    }

    /**
     * 建立toolbar
     *
     * @param toolbar
     */
    public void setToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick({R.id.supplier_add_btn, R.id.supplier_add_more, R.id.supplier_add_return, R.id.supplier_img_add, R.id.supplier_add_card})
    void myClick(View view) {
        switch (view.getId()) {
            case R.id.supplier_add_btn:
                break;
            case R.id.supplier_add_more:
                ll_Cuk.setVisibility(View.VISIBLE);
                ll_Return.setVisibility(View.VISIBLE);
                ll_More.setVisibility(View.GONE);
                break;
            case R.id.supplier_add_return:
                ll_More.setVisibility(View.VISIBLE);
                ll_Cuk.setVisibility(View.GONE);
                ll_Return.setVisibility(View.GONE);
                break;
            case R.id.supplier_img_add:
                // 获取头像
                showPhotoDialog();
                break;
            case R.id.supplier_add_card:
                // 添加银行卡
                startActivity(new Intent(this, AddCardActivity.class));
                break;
            default:
                break;
        }
    }

    private void showPhotoDialog() {
        View view = getLayoutInflater().inflate(R.layout.photo_choose_dialog,
                null);
        dialog = new Dialog(this, R.style.transparentFrameWindowStyle);
        dialog.setContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.x = 0;
        wl.y = getWindowManager().getDefaultDisplay().getHeight();
        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        dialog.onWindowAttributesChanged(wl);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

    //弹出框条目点击事件
    public void click(View source) {
        switch (source.getId()) {
            case R.id.pcd_carme:
                //camera(source);
                fromAlubm();
                break;
            case R.id.pcd_photo:
                fromCamera();
                break;
            case R.id.pcd_cancle:
                dialog.dismiss();
                break;
        }
    }

    public void fromAlubm() {
        // 激活系统图库，选择一张图片
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, PHOTO_REQUEST_GALLERY);
    }


    public void fromCamera() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        // 判断存储卡是否可以用，可用进行存储
        if (BaseUtils.hasSdcard()) {
            intent.putExtra(MediaStore.EXTRA_OUTPUT,
                    Uri.fromFile(new File(Environment
                            .getExternalStorageDirectory(), PHOTO_FILE_NAME)));
        }
        startActivityForResult(intent, PHOTO_REQUEST_CAMERA);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PHOTO_REQUEST_GALLERY) {
            if (data != null) {
                // 得到图片的全路径
                Uri uri = data.getData();
                crop(uri);
            }

        } else if (requestCode == PHOTO_REQUEST_CAMERA) {
            if (BaseUtils.hasSdcard()) {
                tempFile = new File(Environment.getExternalStorageDirectory(), PHOTO_FILE_NAME);
                if (tempFile.exists()) {
                    crop(Uri.fromFile(tempFile));
                } else {
                    JUtils.Toast("取消拍照");
                }
            } else {
                Toast.makeText(AddSupplierActivity.this, "未找到存储卡，无法存储照片！", Toast.LENGTH_SHORT).show();
            }

        } else if (requestCode == PHOTO_REQUEST_CUT) {
            try {
                if (data != null) {
                    if (data.getParcelableExtra("data") != null) {
                        bitmap = data.getParcelableExtra("data");
                        headImage.setImageBitmap(bitmap);
                    }
                    if (tempFile != null) {
                        tempFile.delete();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            // 此处调用上传图片接口
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 图片剪裁
     *
     * @param uri
     */
    private void crop(Uri uri) {
        // 裁剪图片意图
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // 裁剪框的比例，1：1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // 裁剪后输出图片的尺寸大小
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 250);
        // 图片格式
        intent.putExtra("outputFormat", "JPEG");
        intent.putExtra("noFaceDetection", true);// 取消人脸识别
        intent.putExtra("return-data", true);// true:不返回uri，false：返回uri
        startActivityForResult(intent, PHOTO_REQUEST_CUT);
    }


    public File saveFile(Bitmap bm) throws IOException {
        String path = Environment.getExternalStorageDirectory() + "/LKShop/HeadIcon/";
        File dirFile = new File(path);
        if (!dirFile.exists()) {
            dirFile.mkdir();
        }
        String fileName = new Date().getTime() + ".jpg";
        File myCaptureFile = new File(path + fileName);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
        bm.compress(Bitmap.CompressFormat.JPEG, 80, bos);
        bos.flush();
        bos.close();
        return myCaptureFile;
    }

}
