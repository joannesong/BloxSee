package com.example.franciscoandrade.bloxsee.views.student;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franciscoandrade.bloxsee.R;
import com.example.franciscoandrade.bloxsee.model.Questions;
import com.example.franciscoandrade.bloxsee.model.StudentInfo;
import com.example.franciscoandrade.bloxsee.model.StudentQuestions;
import com.example.franciscoandrade.bloxsee.views.StudentActivity;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by Kevintoro on 3/18/18.
 */

public class StudentQuestionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private StudentQuestions studentQuestions;
    private StudentInfo studentInfo;
    private TextView studentQuestion, questionNumber;
    private String studentName;
    private String studentQ;
    private String studentL;
    private CardView cardViewQuestions;
    private Context context;

    public StudentQuestionViewHolder(final View itemView) {
        super(itemView);

        studentQuestion = itemView.findViewById(R.id.questions_tv);
        questionNumber= itemView.findViewById(R.id.qNumber);
        cardViewQuestions = itemView.findViewById(R.id.cardViewQuestionsStudent);

    }
    public void onBind(StudentInfo studentInfo, int position, int size, String studentName, Context context){
        String studentQ = studentInfo.getQuestion();
        this.studentInfo = studentInfo;

        questionNumber.setText(studentInfo.getQuestionNum());
        String question= studentQ.substring(3);
        studentQuestion.setText(question);
        this.context = context;

        cardViewQuestions.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.cardViewQuestionsStudent:

                String currentQuestion = studentQuestion.getText().toString();
                studentName = studentInfo.getName();
                studentQ = "Q"+studentInfo.getQuestionNum();
                studentL = "L"+studentInfo.getLesson();
                Log.d("TEST=", String.valueOf(studentQ));
                Log.d("TEST=", String.valueOf(studentL));

                Intent intent = new Intent(context, BlocklyActivity.class);
                intent.putExtra("currentQuestion", currentQuestion);
                intent.putExtra("studentName", studentName);
                intent.putExtra("SnapShotL",studentL);
                intent.putExtra("SnapShotQ", studentQ);
                context.startActivity(intent);

//                Log.d("hihi", String.valueOf(studentInfo.getQuestion()));
//                Log.d("hihi", String.valueOf(studentInfo.getName()));
//                Log.d("hihi", String.valueOf(studentInfo.getLesson()));

                break;

        }

    }
}
