package net.school_a.app;

import net.school_a.app.model.bean.GoodsChildClassificDataModel;
import net.school_a.app.model.bean.GoodsClassificDataModel;
import net.school_a.app.model.bean.GoodsDataModel;
import net.school_a.app.model.bean.SupplierDatamodel;
import net.school_a.app.model.bean.VipDataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 2017/3/10.
 * 测试数据封装
 */

public class DataProvider {
    /**
     * 获取供应商列表
     *
     * @param page 页码
     * @return
     */
    public static List<SupplierDatamodel> getSupplierList(int page) {
        ArrayList<SupplierDatamodel> arrayList = new ArrayList<>();
        if (page == 4) return arrayList;
        SupplierDatamodel datamodel = new SupplierDatamodel();
        datamodel.setHeadUrl("test");
        datamodel.setName("康南");
        datamodel.setPhone("18388126912");
        datamodel.setCompany("云南天谷科技开发有限公司");
        datamodel.setAddress("云南省昆明市官渡区关上街道宝海路星河民居");
        datamodel.setRemark("备注信息");
        datamodel.setQq("1510624947");
        datamodel.setWeixin("18388126912");
        datamodel.setAlipay("18388126912");
        datamodel.setCard("23423o5i435i4i65049543");
        arrayList.add(datamodel);

        datamodel = new SupplierDatamodel();
        datamodel.setHeadUrl("test");
        datamodel.setName("猪八戒");
        datamodel.setPhone("18388126912");
        datamodel.setCompany("云南天谷科技开发有限公司");
        datamodel.setAddress("云南省昆明市官渡区关上街道宝海路星河民居");
        datamodel.setRemark("备注信息");
        datamodel.setQq("1510624947");
        datamodel.setWeixin("18388126912");
        datamodel.setAlipay("18388126912");
        datamodel.setCard("23423o5i435i4i65049543");
        arrayList.add(datamodel);

        datamodel = new SupplierDatamodel();
        datamodel.setHeadUrl("test");
        datamodel.setName("唐僧");
        datamodel.setPhone("18388126912");
        datamodel.setCompany("云南天谷科技开发有限公司");
        datamodel.setAddress("云南省昆明市官渡区关上街道宝海路星河民居");
        datamodel.setRemark("备注信息");
        datamodel.setQq("1510624947");
        datamodel.setWeixin("18388126912");
        datamodel.setAlipay("18388126912");
        datamodel.setCard("23423o5i435i4i65049543");
        arrayList.add(datamodel);

        return arrayList;
    }

    /**
     * 获取商品一级分类列表
     *
     * @return
     */
    public static List<GoodsClassificDataModel> getGoodsClassficlist() {
        ArrayList<GoodsClassificDataModel> list = new ArrayList<>();
        GoodsClassificDataModel model = new GoodsClassificDataModel();
        model.setUuid("2323");
        model.setUserUUID("ewewqeq");
        model.setName("日用品");
        model.setDesc("dsada");
        model.setList(getChildList());
        list.add(model);

        model = new GoodsClassificDataModel();
        model.setUuid("2323");
        model.setUserUUID("ewewqeq");
        model.setName("家用电器");
        model.setDesc("dsada");
        model.setList(getChildList());
        list.add(model);

        model = new GoodsClassificDataModel();
        model.setUuid("2323");
        model.setUserUUID("ewewqeq");
        model.setName("生鲜");
        model.setDesc("dsada");
        model.setList(getChildList());
        list.add(model);

        model = new GoodsClassificDataModel();
        model.setUuid("2323");
        model.setUserUUID("ewewqeq");
        model.setName("家具建材");
        model.setDesc("dsada");
        model.setList(getChildList());
        list.add(model);

        return list;
    }

    /**
     * 获取商品父分类之子分类集合
     *
     * @return
     */
    private static ArrayList<GoodsChildClassificDataModel> getChildList() {
        ArrayList<GoodsChildClassificDataModel> list = new ArrayList<>();
        GoodsChildClassificDataModel model = new GoodsChildClassificDataModel();
        model.setUuid("123");
        model.setName("五金");
        model.setDesc("dsadasda");
        model.setFatherId("2323");
        list.add(model);

        model = new GoodsChildClassificDataModel();
        model.setUuid("123");
        model.setName("化妆品");
        model.setDesc("dsadasda");
        model.setFatherId("2323");
        list.add(model);

        model = new GoodsChildClassificDataModel();
        model.setUuid("123");
        model.setName("清洁用品");
        model.setDesc("dsadasda");
        model.setFatherId("2323");
        list.add(model);

        model = new GoodsChildClassificDataModel();
        model.setUuid("123");
        model.setName("厨房用品");
        model.setDesc("dsadasda");
        model.setFatherId("2323");
        list.add(model);

        return list;
    }

    public static List<GoodsDataModel> getGoodsList(int page) {
        ArrayList<GoodsDataModel> arrayList = new ArrayList<>();
        if (page == 4) return arrayList;
        GoodsDataModel model = new GoodsDataModel();
        model.setId("dsad");
        model.setName("碧螺春");
        model.setClassic("默认分类");
        model.setFormat("200克");
        model.setInPrice(23.0);
        model.setPrice(30.0);
        model.setCodeStr("abc34324234");
        model.setStock(200);
        model.setSupplier("默认供应商");
        model.setRemark("商品备注");
        arrayList.add(model);

        model = new GoodsDataModel();
        model.setId("dsad");
        model.setName("保温杯");
        model.setClassic("默认分类");
        model.setFormat("200克");
        model.setInPrice(23.0);
        model.setPrice(30.0);
        model.setCodeStr("abc34324234");
        model.setStock(200);
        model.setSupplier("默认供应商");
        model.setRemark("商品备注");
        arrayList.add(model);
        return arrayList;
    }

    public static List<VipDataModel> getVipList(int page) {
        ArrayList<VipDataModel> arrayList = new ArrayList<>();
        if (page == 4) return arrayList;
        VipDataModel model = new VipDataModel();
        model.setId("dsada");
        model.setName("龙文娜");
        model.setPhone("18388126912");
        model.setAddress("大大");
        arrayList.add(model);

        model = new VipDataModel();
        model.setId("dsada");
        model.setName("宋江");
        model.setPhone("18388126912");
        model.setAddress("大大");
        arrayList.add(model);

        model = new VipDataModel();
        model.setId("dsada");
        model.setName("令狐冲");
        model.setPhone("18388126912");
        model.setAddress("大大");
        arrayList.add(model);

        model = new VipDataModel();
        model.setId("dsada");
        model.setName("乔峰");
        model.setPhone("18388126912");
        model.setAddress("大大");
        arrayList.add(model);

        model = new VipDataModel();
        model.setId("dsada");
        model.setName("韦德");
        model.setPhone("18388126912");
        model.setAddress("大大");
        arrayList.add(model);

        return arrayList;
    }

}
