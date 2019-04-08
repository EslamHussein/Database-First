package com.databasefirst.users.view;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.databasefirst.R;
import com.databasefirst.base.view.BaseActivity;
import com.databasefirst.users.adapter.UserRecyclerViewAdapter;
import com.databasefirst.users.presenter.UsersPresenter;
import com.databasefirst.users.presenter.UsersPresenterImpl;
import com.databasefirst.users.repo.UsersRepo;
import com.databasefirst.users.repo.UsersRepoImpl;
import com.databasefirst.users.repo.dto.User;
import com.databasefirst.users.repo.local.DBConstant;
import com.databasefirst.users.repo.local.LocalDB;
import com.databasefirst.users.repo.local.UsersLocalRepo;
import com.databasefirst.users.repo.local.UsersLocalRepoImpl;
import com.databasefirst.users.repo.remote.UsersRemoteRepo;
import com.databasefirst.users.repo.remote.UsersRemoteRepoImpl;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivity extends BaseActivity<UsersPresenter> implements UsersView {
    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView recyclerViewUser;

    private UserRecyclerViewAdapter userRecyclerViewAdapter;

    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected UsersPresenter createPresenter() {

        UsersRemoteRepo remoteUsersRepo = new UsersRemoteRepoImpl();
        LocalDB localDB = Room.databaseBuilder(getApplicationContext(), LocalDB.class, DBConstant.DB_NAME).build();


        UsersLocalRepo localUsersRepo = new UsersLocalRepoImpl(localDB.usersDao());

        UsersRepo usersRepo = new UsersRepoImpl(remoteUsersRepo, localUsersRepo);

        return new UsersPresenterImpl(usersRepo, AndroidSchedulers.mainThread());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewUser = findViewById(R.id.recycler_view_user);

        getPresenter().getUsers();
    }

    @Override
    public void showUsers(List<User> users) {
        Log.d(TAG, "showUsers() returned: " + users.size());
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerViewUser.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerViewUser.setLayoutManager(layoutManager);

        //add divider for spacing
        recyclerViewUser.addItemDecoration(new DividerItemDecoration(getApplicationContext(),
                DividerItemDecoration.VERTICAL));

        // specify an adapter (see also next example)
        userRecyclerViewAdapter = new UserRecyclerViewAdapter(getApplicationContext(), users);
        recyclerViewUser.setAdapter(userRecyclerViewAdapter);
    }

    @Override
    public void showLoading() {

        Log.d(TAG, "showLoading() returned: ");

    }

    @Override
    public void hideLoading() {
        Log.d(TAG, "hideLoading() returned: ");
    }

    @Override
    public void showError(String error) {
        Log.d(TAG, "showError() returned: " + error);
    }
}
