package com.example.register;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.nio.file.FileVisitResult;

public class studentMarksUi extends AppCompatActivity {
    Button backButton;
    FirebaseAuth auth;
    FirebaseFirestore fstore;
    String userId;
    TextView subject1, subject2, subject3, subject4, subject5;
    EditText subject1Assign, subject1Cat1, subject1Exam, subject1Total;
    EditText subject2Assign, subject2Cat1, subject2Exam, subject2Total;
    EditText subject3Assign, subject3Cat1, subject3Exam, subject3Total;
    EditText subject4Assign, subject4Cat1, subject4Exam, subject4Total;
    EditText subject5Assign, subject5Cat1, subject5Exam, subject5Total;
    EditText totalmark, averageMark, remarks;

    @SuppressLint("MissingInflatedId")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_marks_ui);

        backButton = findViewById(R.id.backButton);
        subject1 = findViewById(R.id.subject1);
        subject2 = findViewById(R.id.subjet2);
        subject3 = findViewById(R.id.subjet3);
        subject4 = findViewById(R.id.subjet4);
        subject5 = findViewById(R.id.subjet5);
        subject1Assign = findViewById(R.id.subject1Assign);
        subject2Assign = findViewById(R.id.subject2Assign);
        subject3Assign = findViewById(R.id.subject3Assign);
        subject4Assign = findViewById(R.id.subject4Assign);
        subject5Assign = findViewById(R.id.subject5Assign);

        subject1Cat1 = findViewById(R.id.subject1cat);
        subject2Cat1 = findViewById(R.id.subject2Cat);
        subject3Cat1 = findViewById(R.id.subject3Cat);
        subject4Cat1 = findViewById(R.id.subject4cat);
        subject5Cat1 = findViewById(R.id.subject5Cat);

        subject1Exam = findViewById(R.id.subject1exam);
        subject2Exam = findViewById(R.id.subject2Exam);
        subject3Exam = findViewById(R.id.subject3Exam);
        subject4Exam = findViewById(R.id.subject4exam);
        subject5Exam = findViewById(R.id.subject5exam);

        subject1Total = findViewById(R.id.subject1total);
        subject2Total = findViewById(R.id.subject2total);
        subject3Total = findViewById(R.id.subjet3total);
        subject4Total = findViewById(R.id.subjet4total);
        subject5Total = findViewById(R.id.subject5Total);

        totalmark = findViewById(R.id.totalMarks);
        averageMark = findViewById(R.id.averageScore);
        remarks = findViewById(R.id.remarks);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(studentMarksUi.this, StudentProfile.class));
            }
        });
        auth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        userId = auth.getCurrentUser().getUid();
        DocumentReference reference = fstore.collection("studentMarks").document(userId);

        reference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                if (value != null && value.exists()) {
                    // Retrieve subject1 data
                    double subject1AssignValue = Double.parseDouble(value.getString("subject1.assign"));
                    double subject1Cat1Value = Double.parseDouble(value.getString("subject1.cat"));
                    double subject1ExamValue = Double.parseDouble(value.getString("subject1.exam"));
                    double subject1TotalValue = subject1AssignValue + subject1Cat1Value + subject1ExamValue;

                    subject1Assign.setText(String.valueOf(subject1AssignValue));
                    subject1Cat1.setText(String.valueOf(subject1Cat1Value));
                    subject1Exam.setText(String.valueOf(subject1ExamValue));
                    subject1Total.setText(String.valueOf(subject1TotalValue));
                    // Retrieve subject2 data
                    double subject2AssignValue = Double.parseDouble(value.getString("subject2.assign"));
                    double subject2Cat1Value = Double.parseDouble(value.getString("subject2.cat"));
                    double subject2ExamValue = Double.parseDouble(value.getString("subject2.exam"));
                    double subject2TotalValue = subject2AssignValue + subject2Cat1Value + subject2ExamValue;

                    subject2Assign.setText(String.valueOf(subject1AssignValue));
                    subject2Cat1.setText(String.valueOf(subject1Cat1Value));
                    subject2Exam.setText(String.valueOf(subject1ExamValue));
                    subject2Total.setText(String.valueOf(subject2TotalValue));

                    // Retrieve subject3 data
                    double subject3AssignValue = Double.parseDouble(value.getString("subject3.assign"));
                    double subject3Cat1Value = Double.parseDouble(value.getString("subject3.cat"));
                    double subject3ExamValue = Double.parseDouble(value.getString("subject3.exam"));
                    double subject3TotalValue = subject3AssignValue + subject3Cat1Value + subject3ExamValue;

                    subject3Assign.setText(String.valueOf(subject1AssignValue));
                    subject3Cat1.setText(String.valueOf(subject1Cat1Value));
                    subject3Exam.setText(String.valueOf(subject1ExamValue));
                    subject3Total.setText(String.valueOf(subject3TotalValue));

                    // Retrieve subject4 data
                    double subject4AssignValue = Double.parseDouble(value.getString("subject4.assign"));
                    double subject4Cat1Value = Double.parseDouble(value.getString("subject4.cat"));
                    double subject4ExamValue = Double.parseDouble(value.getString("subject4.exam"));
                    double subject4TotalValue = subject4AssignValue + subject4Cat1Value + subject4ExamValue;

                    subject2Assign.setText(String.valueOf(subject1AssignValue));
                    subject2Cat1.setText(String.valueOf(subject1Cat1Value));
                    subject2Exam.setText(String.valueOf(subject1ExamValue));
                    subject2Total.setText(String.valueOf(subject4TotalValue));
                    // Retrieve subject5 data
                    double subject5AssignValue = Double.parseDouble(value.getString("subject5.assign"));
                    double subject5Cat1Value = Double.parseDouble(value.getString("subject5.cat"));
                    double subject5ExamValue = Double.parseDouble(value.getString("subject5.exam"));
                    double subject5TotalValue = subject5AssignValue + subject5Cat1Value + subject5ExamValue;

                    subject2Assign.setText(String.valueOf(subject1AssignValue));
                    subject2Cat1.setText(String.valueOf(subject1Cat1Value));
                    subject2Exam.setText(String.valueOf(subject1ExamValue));
                    subject2Total.setText(String.valueOf(subject5TotalValue));


                    // Calculate total marks and update UI
                    double totalMarks = subject1TotalValue + subject2TotalValue + subject4TotalValue + subject3TotalValue + subject5TotalValue;/* Add totals for other subjects */
                    ;
//                    totalmark.setText(String.valueOf(totalMarks).toString());

                    // Calculate average marks and update UI
                    double averageMarks = totalMarks / 5; // Assuming 5 subjects
                    totalmark.setText(String.valueOf(averageMarks));

                    // You can also update the remarks based on your criteria
                    remarks.setText(getRemarks(averageMarks));
                    averageMark.setText(getGrade(averageMarks));
                }
            }
        });
    }

    // Example method to determine remarks based on average marks
    private String getRemarks(double averageMarks) {
        if (averageMarks >= 80) {
            return "Excellent";
        } else if (averageMarks >= 60) {
            return "Good";
        } else if (averageMarks >= 40) {
            return "Average";
        } else {
            return "Below Average";
        }
    }

    private String getGrade(double averageMarks) {
        if (averageMarks >= 80) {
            return "A";
        } else if (averageMarks >= 60) {
            return "B";
        } else if (averageMarks >= 40) {
            return "C";
        } else {
            return "SUPP";
        }
    }


}