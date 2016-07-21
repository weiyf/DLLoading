package cn.weiyf.dlloading;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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


    private DLLoadingViewConfig mConfig;


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


    public void init(DLLoadingViewConfig config) {
        this.mConfig = config == null ? new DLLoadingViewConfig() : config;
    }

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
    }


    public void setImageResource(int id) {
        this.mId = id;
        setResource();
    }


    public void setBackGroundColor(int backGroundColor) {
        this.backGroundColor = backGroundColor;
        mGradientDrawable.setColor(backGroundColor);
        mBackGround.setBackground(mGradientDrawable);
    }

    public DLLoadingView() {
        super();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    protected boolean isDebugEnable() {
        return super.isDebugEnable();
    }

    @Override
    protected float getDownScaleFactor() {
        return super.getDownScaleFactor();
    }

    @Override
    protected int getBlurRadius() {
        return super.getBlurRadius();
    }

    @Override
    protected boolean isDimmingEnable() {
        return super.isDimmingEnable();
    }

    @Override
    protected boolean isActionBarBlurred() {
        return super.isActionBarBlurred();
    }

    @Override
    protected boolean isRenderScriptEnable() {
        return super.isRenderScriptEnable();
    }
}
