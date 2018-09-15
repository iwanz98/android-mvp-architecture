package com.wanztudio.mvp.ui.main.dialog;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wanztudio.mvp.R;
import com.wanztudio.mvp.di.component.ActivityComponent;
import com.wanztudio.mvp.ui.base.BaseDialog;
import com.wanztudio.mvp.ui.main.fragment.MainFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

public class MainDialog extends BaseDialog implements MainDialogMvpView {

    private static final String TAG = "MainDialog";

    @Inject
    MainDialogMvpPresenter<MainDialogMvpView> mPresenter;

    public static MainDialog newInstance() {
        MainDialog fragment = new MainDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_main, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {

            component.inject(this);

            setUnBinder(ButterKnife.bind(this, view));

            mPresenter.onAttach(this);
        }

        return view;
    }

    public void show(MainFragment mFragment) {

        super.show(mFragment.getFragmentManager(), TAG);
    }

    @Override
    protected void setUp(View view) {
    }

    @Override
    public void dismissDialog() {
        super.dismissDialog(TAG);
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }
}
