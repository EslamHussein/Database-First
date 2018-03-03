package com.databasefirst.users.presenter;


import com.databasefirst.users.repo.UsersRepo;
import com.databasefirst.users.repo.dto.User;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class UsersPresenterImpl extends UsersPresenter {

    private UsersRepo usersRep;

    private Scheduler scheduler;

    private Disposable disposable;

    public UsersPresenterImpl(UsersRepo usersRep, Scheduler scheduler) {
        this.usersRep = usersRep;
        this.scheduler = scheduler;
    }


    @Override
    public void getUsers() {
        if (!isViewAttached())
            return;

        getView().showLoading();


        disposable = usersRep.getAllUsers().observeOn(scheduler).subscribeWith(new DisposableObserver<List<User>>() {
            @Override
            public void onNext(List<User> users) {
                if (!isViewAttached())
                    return;

                getView().showUsers(users);

            }

            @Override
            public void onError(Throwable e) {
                if (!isViewAttached())
                    return;
                getView().showError(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        disposable.dispose();


    }
}
