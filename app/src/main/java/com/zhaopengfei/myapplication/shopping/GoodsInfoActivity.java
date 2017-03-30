package com.zhaopengfei.myapplication.shopping;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zhaopengfei.myapplication.MyApplication;
import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.gen.ShopInfoDao;
import com.zhaopengfei.myapplication.shopping.bean.ShopInfo;
import com.zhaopengfei.myapplication.shopping.bean.VirtualkeyboardHeight;
import com.zhaopengfei.myapplication.shopping.bean.homepageBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoodsInfoActivity extends AppCompatActivity {

    @BindView(R.id.ib_good_info_back)
    ImageButton ibGoodInfoBack;
    @BindView(R.id.ib_good_info_more)
    ImageButton ibGoodInfoMore;
    @BindView(R.id.iv_good_info_image)
    ImageView ivGoodInfoImage;
    @BindView(R.id.tv_good_info_name)
    TextView tvGoodInfoName;
    @BindView(R.id.tv_good_info_desc)
    TextView tvGoodInfoDesc;
    @BindView(R.id.tv_good_info_price)
    TextView tvGoodInfoPrice;
    @BindView(R.id.tv_good_info_store)
    TextView tvGoodInfoStore;
    @BindView(R.id.tv_good_info_style)
    TextView tvGoodInfoStyle;
    @BindView(R.id.wb_good_info_more)
    WebView wbGoodInfoMore;
    @BindView(R.id.progressbar)
    ProgressBar progressbar;
    @BindView(R.id.tv_good_info_callcenter)
    TextView tvGoodInfoCallcenter;
    @BindView(R.id.tv_good_info_collection)
    TextView tvGoodInfoCollection;
    @BindView(R.id.tv_good_info_cart)
    TextView tvGoodInfoCart;
    @BindView(R.id.btn_good_info_addcart)
    Button btnGoodInfoAddcart;
    @BindView(R.id.ll_goods_root)
    LinearLayout llGoodsRoot;
    @BindView(R.id.tv_more_share)
    TextView tvMoreShare;
    @BindView(R.id.tv_more_search)
    TextView tvMoreSearch;
    @BindView(R.id.tv_more_home)
    TextView tvMoreHome;
    @BindView(R.id.btn_more)
    Button btnMore;
    @BindView(R.id.ll_root)
    LinearLayout llRoot;
//    private String image;
//    private String money;
//    private String name;
    private ShopInfoDao shopInfoDao;
    private homepageBean.ResultBean.RecordsBean recordBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_info);
        recordBean = (homepageBean.ResultBean.RecordsBean) getIntent().getSerializableExtra("image");
        recordBean.setNumber(1);
        ButterKnife.bind(this);
        shopInfoDao = MyApplication.getInstances().getDaoSession().getShopInfoDao();
        setData();

    }


    private void setData() {

//        image = getIntent().getStringExtra(homefragmentAdapter.IMAGE);
//        money = getIntent().getStringExtra(homefragmentAdapter.MONEY);
//        name = getIntent().getStringExtra(homefragmentAdapter.NAME);


        //Toast.makeText(this, ""+ goodsBean.toString(), Toast.LENGTH_SHORT).show();
        //設置圖片
        Log.e("picture", "=="+recordBean.getImgUrl());
        Glide.with(this)
                .load(recordBean.getImgUrl())
                .into(ivGoodInfoImage);


//        //2設置價格和名稱
        tvGoodInfoName.setText(recordBean.getTitle());
        tvGoodInfoPrice.setText("￥" + recordBean.getSalvePrice());

        //3加載頁面
    }


    @OnClick({R.id.ib_good_info_back, R.id.ib_good_info_more, R.id.tv_good_info_callcenter, R.id.tv_good_info_collection, R.id.tv_good_info_cart, R.id.btn_good_info_addcart, R.id.tv_more_share, R.id.tv_more_search, R.id.tv_more_home, R.id.btn_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_good_info_back:
                finish();
                break;
            case R.id.btn_good_info_addcart:
                Toast.makeText(this, "添加到购物车", Toast.LENGTH_SHORT).show();
                showPopwindow();
                break;

            case R.id.tv_more_home:
                Toast.makeText(this, "主页", Toast.LENGTH_SHORT).show();
//                intent = new Intent(this, MainActivity.class);
//                intent.putExtra("checked",R.id.rb_home);
//                startActivity(intent);
                break;
            case R.id.btn_more:
                Toast.makeText(this, "消失更多页面", Toast.LENGTH_SHORT).show();
                llRoot.setVisibility(View.GONE);
                break;
        }
    }


//    //缓存
//    private GoodsBean tempGoodsBean;
//
//    private boolean isExist = false;


    //-------------------------------------------

    //    /**
//     * 显示popupWindow
//     */
    private void showPopwindow() {

        // 1 利用layoutInflater获得View
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.popupwindow_add_product, null);

        // 2下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        final PopupWindow window = new PopupWindow(view,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        // 3 参数设置
        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);

        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xFFFFFFFF);
        window.setBackgroundDrawable(dw);

        // 设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.mypopwindow_anim_style);


        // 4 控件处理
        ImageView iv_goodinfo_photo = (ImageView) view.findViewById(R.id.iv_goodinfo_photo);
        TextView tv_goodinfo_name = (TextView) view.findViewById(R.id.tv_goodinfo_name);
        TextView tv_goodinfo_price = (TextView) view.findViewById(R.id.tv_goodinfo_price);
        AddSubView nas_goodinfo_num = (AddSubView) view.findViewById(R.id.nas_goodinfo_num);
        Button bt_goodinfo_cancel = (Button) view.findViewById(R.id.bt_goodinfo_cancel);
        Button bt_goodinfo_confim = (Button) view.findViewById(R.id.bt_goodinfo_confim);

        // 加载图片
        Glide.with(GoodsInfoActivity.this).load(recordBean.getImgUrl()).into(iv_goodinfo_photo);

        // 名称
        tv_goodinfo_name.setText(recordBean.getTitle());
        // 显示价格
        tv_goodinfo_price.setText(recordBean.getSalvePrice()+"");

        // 设置最大值和当前值
        nas_goodinfo_num.setMaxvalue(120);

        nas_goodinfo_num.setListener(new AddSubView.OnNumBerChangerListener() {
            @Override
            public void onNumberChanger(int value) {

                recordBean.setNumber(value);

            }
        });




        bt_goodinfo_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
            }
        });

        bt_goodinfo_confim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
                //添加购物车
                //  CartStorage.getInstance(GoodsInfoActivity.this).addData(tempGoodsBean);
//                Log.e("TAG", "66:" + tempGoodsBean.toString());
                Toast.makeText(GoodsInfoActivity.this, "添加购物车成功", Toast.LENGTH_SHORT).show();

                // List<ShopInfo> shopInfos = shopInfoDao.loadAll();


                ShopInfo shopInfo = new ShopInfo(null, recordBean.getImgUrl(), recordBean.getTitle(), recordBean.getSalvePrice(), recordBean.getNumber(), true);
                shopInfoDao.insert(shopInfo);


            }
        });


        window.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                window.dismiss();
            }
        });

        // 5 在底部显示
        window.showAtLocation(GoodsInfoActivity.this.findViewById(R.id.ll_goods_root),
                Gravity.BOTTOM, 0, VirtualkeyboardHeight.getBottomStatusHeight(GoodsInfoActivity.this));

    }


}
