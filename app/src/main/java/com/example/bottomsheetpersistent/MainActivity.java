package com.example.bottomsheetpersistent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {
private BottomSheetBehavior bottomSheetBehavior;private TextView textView;@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View bottom=findViewById(R.id.bottom_sheet);bottomSheetBehavior=BottomSheetBehavior.from(bottom);textView=findViewById(R.id.text);
        Button button=findViewById(R.id.button);Button button2=findViewById(R.id.button2);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
           }
       });
       button2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

           }
       });
       bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
           @Override
           public void onStateChanged(@NonNull View view, int i) {
               switch (i){
                   case BottomSheetBehavior.STATE_COLLAPSED:
                       textView.setText("Collapsed ...");break;
                   case BottomSheetBehavior.STATE_EXPANDED:
                       textView.setText("Expanded ...");break;
                   case BottomSheetBehavior.STATE_DRAGGING:
                       textView.setText("Dragging ...");break;
                   case BottomSheetBehavior.STATE_HIDDEN:
                       textView.setText("Hidden ...");break;
                   case BottomSheetBehavior.STATE_SETTLING:
                       textView.setText("Settling ...");break;
               }
           }

           @Override
           public void onSlide(@NonNull View view, float v) {

           }
       });
    }
}