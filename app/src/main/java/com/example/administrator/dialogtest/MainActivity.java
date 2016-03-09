package com.example.administrator.dialogtest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        show = (TextView)findViewById(R.id.show);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simple();
            }
        });
    }

    public void simple()
    {
        TableLayout tableLayout =  (TableLayout)getLayoutInflater().inflate(R.layout.dialog_login, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("simple dialog")
                .setIcon(R.mipmap.ic_launcher)
                .setView(tableLayout);
                //.setMessage("对话框的测试内容\n第二行内容");
        setPositiveButton(builder);
        setNegativeButton(builder)
                .create()
                .show();

    }

    public void multiChoice(View source)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("multiplechoice")
                .setIcon(R.mipmap.ic_launcher)
                .setMultiChoiceItems(items,new boolean[]{false,true,false,true},null);
        setPositiveButton(builder);
        setNegativeButton(builder);
    }

    private AlertDialog.Builder setPositiveButton(AlertDialog.Builder builder)
    {
        return builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                show.setText("单击了[确定]按钮!");

            }
        });
    }
    private AlertDialog.Builder setNegativeButton(AlertDialog.Builder builder)
    {
        return builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                show.setText("单击了[取消]按钮!");
            }
        });
    }

}
