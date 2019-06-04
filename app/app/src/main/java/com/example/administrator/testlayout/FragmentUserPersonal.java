package com.example.administrator.testlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentUserPersonal extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return LayoutInflater.from(getActivity()).inflate(R.layout.user_personal, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        initView();
        initViewPager();
    }

    private void initView() {
        mTabLayout = getActivity().findViewById(R.id.tablayout1);
        mViewPager = getActivity().findViewById(R.id.viewpager1);
    }

    private void initViewPager() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentUserCollection());
        fragments.add(new FragmentUserWishlist());
        fragments.add(new FragmentUserWorks());
        // 创建ViewPager适配器
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(this.getChildFragmentManager());
        myPagerAdapter.setFragments(fragments);
        // 给ViewPager设置适配器
        mViewPager.setAdapter(myPagerAdapter);

        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());

        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.getTabAt(0).setText("library");
        mTabLayout.getTabAt(1).setText("wishlist");
        mTabLayout.getTabAt(2).setText("discography");

    }
}
