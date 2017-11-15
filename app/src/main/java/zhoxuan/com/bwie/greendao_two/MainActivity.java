package zhoxuan.com.bwie.greendao_two;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import zhoxuan.com.bwie.greendao_two.gen.UserDao;

public class MainActivity extends AppCompatActivity {
   Button btn1,btn2,btn3,btn4;
    private UserDao userDao;
    private User user1;
    private User user2;
    private User user3;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);

        userDao = GreenDaoManager.getInstance().getNewSession().getUserDao();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user1 = new User(null, "zhangsan", 18);
                user2 = new User(null, "lisi", 18);
                user3 = new User(null, "wangwu", 18);
//                userDao.insert(user1);
//                userDao.insert(user2);
//                userDao.insert(user3);
                Log.e("main",user1.getName());
                Log.e("main",user2.getName());
                Log.e("main",user3.getName());

            }
        });
      btn2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

//              userDao.delete(user1);
              userDao.deleteAll();

          }
      });

        /**
         * 删
         */
btn3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        user2 = new User((long)2, "wangwu", 18);
        userDao.update(user2);
    }
});

      btn4.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              List<User> list = userDao.loadAll();
              String username="";
              for (int i=0;i<list.size();i++){
                  username+=list.get(i).getId()+list.get(i).getName()+list.get(i).getAge();
              }
          }
      });


    }
}
