package demo.zkp.com.domain.interactors.base;

import executor.Executor;
import executor.MainThread;

/**
 * Created by Administrator on 2017/1/6.
 */

public abstract class BaseInteractor {

    protected Executor mThreadExecutor;
    protected MainThread mMainThread;

    protected volatile boolean mIsCanceled;
    protected volatile boolean mIsRunning;

    public BaseInteractor(Executor threadExecutor, MainThread mainThread) {
        mThreadExecutor = threadExecutor;
        mMainThread = mainThread;
    }

    public abstract void run();

    public boolean isRunning() {
        return mIsRunning;
    }

    public void onFinished() {
        mIsRunning = false;
        mIsCanceled = false;
    }

    public void execute() {

        // mark this interactor as running
        this.mIsRunning = true;

        // start running this interactor in a background thread
        mThreadExecutor.execute(this);
    }
}
