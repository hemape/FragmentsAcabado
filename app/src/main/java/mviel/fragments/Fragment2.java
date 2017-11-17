package mviel.fragments;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class Fragment2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private FragmentManager fm;
    private FragmentTransaction ft;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private int contador;
    private OnFragmentInteractionListener2 mListener;
    private Comunicador c;
    FrameLayout fl;


    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment2() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_fragment2, container, false);

        FrameLayout fl = (FrameLayout) v.findViewById(R.id.FrameLayout1);

        contador=MainActivity.contador;
        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                fm = getFragmentManager();
                ft = fm.beginTransaction();

                if (!mListener.estaFragment3EnActivity()) {

                    c = (Comunicador) getActivity();
                    Toast.makeText(getActivity().getBaseContext(), "Mostrant Fragment3", Toast.LENGTH_SHORT).show();
                    ft.add(R.id.canto_inferior_dret, Fragment3.newInstance("", ""));


                    c.comunicat(contador);
                }else{
                    Toast.makeText(getActivity().getBaseContext(), "Amagant Fragment3", Toast.LENGTH_SHORT).show();
                    ft.remove(getActivity().getFragmentManager().findFragmentById(R.id.canto_inferior_dret));
                }
                ft.commit();
            }
        });
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction2(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener2) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener2 {
        // TODO: Update argument type and name
        void onFragmentInteraction2(Uri uri);
        boolean estaFragment3EnActivity();
    }

    public interface Comunicador{
        void comunicat(int cont);
    }

}