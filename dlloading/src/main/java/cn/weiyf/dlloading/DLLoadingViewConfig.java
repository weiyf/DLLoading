package cn.weiyf.dlloading;

/**
 * Created by weiyf on 16-7-21.
 */

public class DLLoadingViewConfig {


    // TODO: 16-7-21
    // 1. 随机切换loading gif
    // 2. 设定最小显示时间
    // 3. 设定最大显示时间
    // 4. dismiss回调
    // 5. debug选项
    // 6. DownScaleFactor
    // 7. BlurRadius
    // 9. DimmingEnable
    // 10. ActionBarBlurred
    // 11. RenderScriptEnable

    private int minTime = 3000;

    private int maxTime = 30000;

    private boolean isDebug = false;

    private float downScaleFactor = 4.0f;

    private int blurRadius = 8;

    private boolean isDimmingEnable = false;

    private boolean isActionBarBlurred = false;

    private boolean isRenderScriptEnable = false;


    public static class Builder {

        private int minTime = 3000;

        private int maxTime = 30000;

        private boolean isDebug = false;

        private float downScaleFactor = 4.0f;

        private int blurRadius = 8;

        private boolean isDimmingEnable = false;

        private boolean isActionBarBlurred = false;

        private boolean isRenderScriptEnable = false;

        public Builder setMinTime(int minTime) {
            this.minTime = minTime;
            return this;
        }

        public Builder setMaxTime(int maxTime) {
            this.maxTime = maxTime;
            return this;
        }

        public Builder isDebug(boolean isDebug) {
            this.isDebug = isDebug;
            return this;
        }

        public Builder setDownScaleFactor(float downScaleFactor) {
            this.downScaleFactor = downScaleFactor;
            return this;
        }

        public Builder setBlurRadius(int blurRadius) {
            this.blurRadius = blurRadius;
            return this;
        }

        public Builder isDimmingEnable(boolean isDimmingEnable) {
            this.isDimmingEnable = isDimmingEnable;
            return this;
        }

        public Builder isActionBarBlurred(boolean isActionBarBlurred) {
            this.isActionBarBlurred = isActionBarBlurred;
            return this;
        }

        public Builder isRenderScriptEnable(boolean isRenderScriptEnable) {
            this.isRenderScriptEnable = isRenderScriptEnable;
            return this;
        }

        public DLLoadingViewConfig build() {
            DLLoadingViewConfig config = new DLLoadingViewConfig();
            applyConfig(config);
            return config;
        }

        private void applyConfig(DLLoadingViewConfig config) {
            config.minTime = this.minTime;
            config.maxTime = this.maxTime;
            config.isDebug = this.isDebug;
            config.downScaleFactor = this.downScaleFactor;
            config.blurRadius = this.blurRadius;
            config.isDimmingEnable = this.isDimmingEnable;
            config.isActionBarBlurred = this.isActionBarBlurred;
            config.isRenderScriptEnable = this.isRenderScriptEnable;
        }


    }

    public interface onDismissedListener {

        void ondismissed();

    }

}
