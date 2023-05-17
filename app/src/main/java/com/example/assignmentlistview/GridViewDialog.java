package com.example.assignmentlistview;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class GridViewDialog extends Dialog {
    private GridImageAdapter gridImageAdapter;
    private TextView title;
    private GridView gridView;
    private Button btnOK;

    ArrayList<ListData> imgList = new ArrayList<ListData>();

    public GridViewDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.activity_grid_view_dialog);
        title = findViewById(R.id.titleGridViewDialog);
        gridView = findViewById(R.id.gridView);
        btnOK = findViewById(R.id.btnDialogOK);

        imgList.add(new ListData(R.drawable.image1, "Img 1"));
        imgList.add(new ListData(R.drawable.image2, "Img 2"));
        imgList.add(new ListData(R.drawable.image3, "Img 3"));
        imgList.add(new ListData(R.drawable.image4, "Img 4"));
        imgList.add(new ListData(R.drawable.image5, "Img 5"));

        gridImageAdapter = new GridImageAdapter(context, imgList);
        gridView.setAdapter(gridImageAdapter);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

    }
}