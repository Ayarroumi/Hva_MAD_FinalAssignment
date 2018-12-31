package com.example.anass.festivalapp.Activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.anass.festivalapp.Adapters.SectionsStatePagerAdapter;
import com.example.anass.festivalapp.Entities.User;
import com.example.anass.festivalapp.Entities.Wallet;
import com.example.anass.festivalapp.Fragments.FestivalFragment;
import com.example.anass.festivalapp.Fragments.HomeFragment;
import com.example.anass.festivalapp.Fragments.MyTicketFragment;
import com.example.anass.festivalapp.Fragments.TransactionFragment;
import com.example.anass.festivalapp.Fragments.UpgradeFragment;
import com.example.anass.festivalapp.Fragments.WalletFragment;
import com.example.anass.festivalapp.R;
import com.example.anass.festivalapp.ViewModel.UserViewModel;
import com.example.anass.festivalapp.ViewModel.WalletViewModel;

public class LoggedInActivity extends AppCompatActivity {

    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;
    private ViewPager mViewPager;
    private WalletViewModel walletViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager){

        mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        mSectionsStatePagerAdapter.addFragment(HomeFragment.newInstance(), "HomeFragment");
        mSectionsStatePagerAdapter.addFragment(FestivalFragment.newInstance(), "FestivalFragment");
        mSectionsStatePagerAdapter.addFragment(WalletFragment.newInstance(),"WalletFragment");
        mSectionsStatePagerAdapter.addFragment(TransactionFragment.newInstance(), "TransactionFragment");
        mSectionsStatePagerAdapter.addFragment(MyTicketFragment.newInstance(), "MyTicketFragment");
        mSectionsStatePagerAdapter.addFragment(UpgradeFragment.newInstance(), "UpgradeFragment");
        mViewPager.setAdapter(mSectionsStatePagerAdapter);
    }

    public void setmViewPager(String title){
        int index = mSectionsStatePagerAdapter.getIndexOfTitle(title);
        mViewPager.setCurrentItem(index);
    }

    @Override
    public void onBackPressed() {
        int currentItem = mViewPager.getCurrentItem();
        System.out.println(currentItem + "!!!!!!!");
        if (currentItem != 0) {
            mViewPager.setCurrentItem(
                    getBackFragment(mSectionsStatePagerAdapter.getmFragmentTitle(mViewPager.getCurrentItem())),
                    false);
        }else{
            finish();
        }
    }

    private Integer getBackFragment(String title) {
        switch (title) {
            case "FestivalFragment":
                return mSectionsStatePagerAdapter.getIndexOfTitle("HomeFragment");
            case "WalletFragment":
                return mSectionsStatePagerAdapter.getIndexOfTitle("HomeFragment");
            case "MyTicketFragment":
                return mSectionsStatePagerAdapter.getIndexOfTitle("HomeFragment");
            case "FestivalDetailFragment":
                return mSectionsStatePagerAdapter.getIndexOfTitle("FestivalFragment");
            case "TransactionFragment":
                return mSectionsStatePagerAdapter.getIndexOfTitle("WalletFragment");
            case "UpgradeFragment":
                return mSectionsStatePagerAdapter.getIndexOfTitle("WalletFragment");
            default:
                return null;
        }

    }


}
