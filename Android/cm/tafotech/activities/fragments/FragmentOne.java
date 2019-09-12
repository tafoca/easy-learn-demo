package cm.tafotech.activities.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import cm.tafotech.R;

public class FragmentOne extends Fragment {
    private EditText editText;
    private Button button;
    FagmentOneListerner listerner;

    public  interface  FagmentOneListerner{
        void onInputOneSent(CharSequence charSequence); //method sending data another fragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        editText = v.findViewById(R.id.entre);
        button = v.findViewById(R.id.btn_ok);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence in = editText.getText();
                listerner.onInputOneSent(in);
            }
        });
        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FagmentOneListerner)
            listerner = (FagmentOneListerner) context;
        else
            throw new RuntimeException(context.toString()+"vous devez implement l'interface FagmentOneListerner");
    }

    public  void updateeditText(CharSequence newText){
        editText.setText(newText);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listerner =null;
    }
}
