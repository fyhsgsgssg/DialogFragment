package com.fyh.mydialogfragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;


/**
 * @author by nate_fu on 2018/9/13.
 * @version vision 1.0
 * @Email: fuyonghui@zjhcsoft.com
 */
public class MyDialogFragment extends DialogFragment {
    private View view;
    private ViewPager viewPager;
    private SmartTabLayout vpTab;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.CustomDialog);
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dialog,container,false);
        initViewpage();
        return view;


    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Window window = getDialog().getWindow();
        getDialog().setCanceledOnTouchOutside(true);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        window.setWindowAnimations(R.style.dialogWindowAnim);
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.dimAmount=0f;
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT ;
        wlp.height =WindowManager.LayoutParams.MATCH_PARENT ;
        window.setAttributes(wlp);
    }

    private  void  initViewpage(){
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getChildFragmentManager(), FragmentPagerItems.with(getActivity())
                .add("XX",InfoFragment.class)
                .add("XX",InfoFragment.class)
                .add("XX",InfoFragment.class)
                .add("XX",InfoFragment.class)
                .add("XX",InfoFragment.class)
                .create());

        viewPager =  (ViewPager)view.findViewById(R.id.vp);
        viewPager.setAdapter(adapter);
        vpTab =(SmartTabLayout)view.findViewById(R.id.vp_tab);
        vpTab.setViewPager( viewPager);

    }



    @Override
    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);
    }

}
