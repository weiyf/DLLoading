package cn.weiyf.dlloading;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.util.Random;
import fr.tvbarthel.lib.blurdialogfragment.SupportBlurDialogFragment;

/**
 * Created by Roger on 2016/4/28.
 */
public class DLLoadingView extends SupportBlurDialogFragment {

    private Dialog mDialog;
    private GradientDrawable mGradientDrawable;
    private int mRadius = 10;
    private float mDownScaleFactor = 5.0f;
    private boolean mDimming = true;
    private boolean mBlurredActionBar = false;
    private int CornerRadius = 30;
    private int backGroundColor = Color.parseColor("#001991EC");
    private int mId;
    private ImageView mLoading;
    private RelativeLayout mBackGround;

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

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (mDialog == null) {
            mDialog = new Dialog(getActivity(), R.style.dl_dialog);
            mDialog.setContentView(R.layout.dialog_loading);
            mDialog.setCanceledOnTouchOutside(true);
            mDialog.getWindow().setGravity(Gravity.CENTER);
            mLoading = (ImageView) mDialog.findViewById(R.id.iv_loading);
            mBackGround = (RelativeLayout) mDialog.findViewById(R.id.back_ground);
            mGradientDrawable = new GradientDrawable();
            mGradientDrawable.setCornerRadius(CornerRadius);
            if (mId == 0) {
                mId = mIds[new Random().nextInt(20)];
            }
            setImageResource(mId);
        }
        return mDialog;
    }

    private void setResource() {
        if (mDialog == null) {
            return;
        }
        Glide.with(getActivity()).load(mId).asGif().diskCacheStrategy(DiskCacheStrategy.NONE).into(mLoading);
        setBackGroundColor(BitmapUtil.getPixColor(BitmapFactory.decodeResource(getResources(), mId)));
        mGradientDrawable.setColor(backGroundColor);
        mBackGround.setBackground(mGradientDrawable);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        mDialog = null;
    }

    public void setImageResource(int id) {
        this.mId = id;
        setResource();
    }

    public void setBlurredActionBar(boolean mBlurredActionBar) {
        this.mBlurredActionBar = mBlurredActionBar;
    }

    public void setCornerRadius(int cornerRadius) {
        CornerRadius = cornerRadius;
    }

    public void setBackGroundColor(int backGroundColor) {
        this.backGroundColor = backGroundColor;
        mGradientDrawable.setColor(backGroundColor);
        mBackGround.setBackground(mGradientDrawable);
    }

    public void setRadius(int mRadius) {
        this.mRadius = mRadius;
    }

    public void setDownScaleFactor(float mDownScaleFactor) {
        this.mDownScaleFactor = mDownScaleFactor;
    }

    public void setDimming(boolean mDimming) {
        this.mDimming = mDimming;
    }

    @Override
    protected boolean isDimmingEnable() {
        return mDimming;
    }

    @Override
    protected boolean isActionBarBlurred() {
        return mBlurredActionBar;
    }

    @Override
    protected float getDownScaleFactor() {
        return mDownScaleFactor;
    }

    @Override
    protected int getBlurRadius() {
        return mRadius;
    }

    @Override
    protected boolean isDebugEnable() {
        return true;
    }

}
