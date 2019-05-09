package b.com.weichunhao20190506;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hjm.bottomtabbar.BottomTabBar;

import b.com.weichunhao20190506.fragment.FragmnetFour;
import b.com.weichunhao20190506.fragment.FragmnetOne;
import b.com.weichunhao20190506.fragment.FragmnetThree;
import b.com.weichunhao20190506.fragment.FragmnetTwo;

public class MainActivity extends AppCompatActivity {
       BottomTabBar tabBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabBar=findViewById(R.id.buttom_tap_bar);


         tabBar.init(getSupportFragmentManager())
                 .setTabPadding(2,4,6)
                 .isShowDivider(false)
                 .setFontSize(20)
                 .setImgSize(30,30)
                 .setChangeColor(Color.RED,Color.BLUE)
                 .addTabItem("全部订单",R.mipmap.ic_launcher_round, FragmnetOne.class)
                 .addTabItem("待付款",R.mipmap.ic_launcher_round, FragmnetTwo.class)
                 .addTabItem("待收货",R.mipmap.ic_launcher_round, FragmnetThree.class)
                 .addTabItem("待评价",R.mipmap.ic_launcher_round, FragmnetFour.class)
                 .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                     @Override
                     public void onTabChange(int position, String name) {

                     }
                 });

    }
}
