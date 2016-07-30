package cn.weiyf.androidframe;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.Random;

/**
 * Created by Roger on 2016/4/28.
 */
public class DLLoading extends DialogFragment {

    private static DLLoading mDLLoading;

    private Random mRandom;

    private ImageView mLoading;

    private RelativeLayout mBackground;

    private GradientDrawable mGradientDrawable;

    private Dialog mDialog;

    private int mId;

    private DismissListener mDismissListener;


    private int[] mIds = {
            R.drawable.num1, R.drawable.num2,
            R.drawable.num3, R.drawable.num4,
            R.drawable.num5, R.drawable.num6,
            R.drawable.num7, R.drawable.num8,
            R.drawable.num9, R.drawable.num10,
            R.drawable.num11, R.drawable.num12,
            R.drawable.num13, R.drawable.num14,
            R.drawable.num15, R.drawable.num16,
            R.drawable.num17, R.drawable.num18,
            R.drawable.num19, R.drawable.num20,
    };

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setCornerRadius(30);
        mDialog = new Dialog(getActivity(), R.style.dl_dialog);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_loading, null, false);
        mLoading = (ImageView) view.findViewById(R.id.iv_loading);
        mBackground = (RelativeLayout) view.findViewById(R.id.back_ground);
        this.mId = getRandomResId();
        Glide.with(getActivity()).load(mId).asGif()
                .diskCacheStrategy(DiskCacheStrategy.NONE).into(mLoading);
        seetBackGroundColor();
        mDialog.setContentView(view);
        mDialog.setCancelable(true);
        mDialog.getWindow().setGravity(Gravity.CENTER);
        return mDialog;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (mDismissListener != null) {
            mDismissListener.onDismissed();
        }
        if (mDialog != null) {
            mDialog = null;
        }
    }

    private void seetBackGroundColor() {
        int pixColor = BitmapUtil.getPixColor(BitmapFactory.decodeResource(getResources(), mId));
        mGradientDrawable.setColor(pixColor);
        mBackground.setBackground(mGradientDrawable);
    }

    public static DLLoading show(FragmentManager fragmentManager) {
        if (mDLLoading == null) {
            mDLLoading = new DLLoading();
        }
        mDLLoading.show(fragmentManager, "loading");
        return mDLLoading;
    }

    private int getRandomResId() {
        if (mRandom == null) {
            mRandom = new Random();
        }
        return mIds[mRandom.nextInt(20)];
    }

    public void setDismissListener(DismissListener dismissListener) {
        this.mDismissListener = dismissListener;
    }

    public interface DismissListener {
        void onDismissed();
    }

}
