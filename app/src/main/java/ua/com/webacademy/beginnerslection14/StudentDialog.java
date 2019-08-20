package ua.com.webacademy.beginnerslection14;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;

public class StudentDialog extends DialogFragment {
    private StudentView mStudentView;
    private Student mStudent;

    private Button mButtonOk;
    private Button mButtonCancel;

    private StudentDialogInterface dialogListener;

    public static StudentDialog newInstance(Student student) {
        StudentDialog dialog = new StudentDialog();

        Bundle args = new Bundle();
        args.putParcelable("Student", student);
        dialog.setArguments(args);

        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.student_dialog, null, false);
        mStudentView = view.findViewById(R.id.viewStudent);

        mStudent = getArguments().getParcelable("Student");
        mStudentView.setStudent(mStudent);

        mButtonOk = view.findViewById(R.id.buttonOk);
        mButtonCancel = view.findViewById(R.id.buttonCancel);

        mButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        mButtonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStudentView.validate()) {
                    if (dialogListener != null) {
                        dialogListener.onOkClick(mStudentView.getStudent());
                    }

                    dismiss();
                }
            }
        });

        return view;
    }

    public void setOnOkClickListener(StudentDialogInterface listener) {
        dialogListener = listener;
    }

    public interface StudentDialogInterface {
        void onOkClick(Student student);
    }
}
