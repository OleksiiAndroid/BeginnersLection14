package ua.com.webacademy.beginnerslection14;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class StudentView extends LinearLayout {
    RequiredEditText mEditTextFirstName;
    RequiredEditText mEditTextLastName;
    RequiredEditText mEditTextAge;

    private Student mStudent;

    public StudentView(Context context) {
        super(context);

        init(context);
    }

    public StudentView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public void init(Context context) {
        View view = inflate(context, R.layout.view_student, this);

        mEditTextFirstName = view.findViewById(R.id.firstName);
        mEditTextLastName = findViewById(R.id.lastName);
        mEditTextAge = findViewById(R.id.age);
    }

    public void setStudent(Student student) {
        clean();

        if (student != null) {
            this.mStudent = student;

            mEditTextFirstName.setText(mStudent.FirstName);
            mEditTextLastName.setText(mStudent.LastName);
            mEditTextAge.setText(String.valueOf(mStudent.Age));
        }
    }

    public Student getStudent() {
        this.mStudent.FirstName = mEditTextFirstName.getText().toString();
        this.mStudent.LastName = mEditTextLastName.getText().toString();
        this.mStudent.Age = Integer.valueOf(mEditTextAge.getText().toString());

        return this.mStudent;
    }

    public void clean() {
        mStudent = null;

        mEditTextFirstName.setText(null);
        mEditTextLastName.setText(null);
        mEditTextAge.setText(null);
    }

    public boolean validate() {
        return mEditTextFirstName.validate() & mEditTextLastName.validate() & mEditTextAge.validate();
    }
}
