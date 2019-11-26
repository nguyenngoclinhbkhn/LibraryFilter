package com.cpr.libraryfilter.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import com.cpr.libraryfilter.R;
import com.cpr.libraryfilter.listener.OnBitmapListener;
import com.cpr.libraryfilter.model.Filter;

import org.wysaid.common.Common;
import org.wysaid.nativePort.CGEFFmpegNativeLibrary;
import org.wysaid.nativePort.CGENativeLibrary;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FilterConfig {
    private Context context;
    private OnBitmapListener listener;

    public CGENativeLibrary.LoadImageCallback mLoadImageCallback = new CGENativeLibrary.LoadImageCallback() {
        @Override
        public Bitmap loadImage(String name, Object arg) {
            Log.i(Common.LOG_TAG, "Loading file: ");
            AssetManager am = context.getAssets();
            InputStream is;
            try {
                is = am.open(name);
            } catch (IOException e) {
                Log.e(Common.LOG_TAG, "Can not open file ");
                return null;
            }
            return BitmapFactory.decodeStream(is);
        }

        @Override
        public void loadImageOK(Bitmap bmp, Object arg) {
            Log.i(Common.LOG_TAG, "Loading bitmap over, you can choose to recycle or cache");
            bmp.recycle();
        }
    };


    public FilterConfig(OnBitmapListener listener, Context context) {
        this.context = context;
        this.listener = listener;
        CGENativeLibrary.setLoadImageCallback(mLoadImageCallback, null);

    }

    public static final String EFFECT_CONFIGS[] = {
            "Normal",
            "@curve RGB(0,255)(255,0) @style cm mapping0.jpg 80 80 8 3",
            "@beautify face 1 480 640", //Beautify
            "@adjust lut edgy_amber.png",
            "@adjust lut filmstock.png",
            "@adjust lut foggy_night.png",
            "@adjust lut late_sunset.png",
            "@adjust lut soft_warming.png",
            "@adjust lut wildbird.png",
            "@blur lerp 1",
            "#unpack @style sketch 0.9",
            "#unpack @krblend sr hehe.jpg 100 ",
            "#unpack @krblend ol hehe.jpg 100",
            "#unpack @krblend add hehe.jpg 100",
            "#unpack @krblend darken hehe.jpg 100",
            "@style crosshatch 0.01 0.003 ",
            "@style edge 1 2 @curve RGB(0, 255)(255, 0) ",
            "@style edge 1 2 @curve RGB(0, 255)(255, 0) @adjust saturation 0 @adjust level 0.33 0.71 0.93 ",
            "@vigblend overlay 255 0 0 255 100 0.12 0.54 0.5 0.5 3 ",
            "@curve R(0, 0)(63, 101)(200, 84)(255, 255)G(0, 0)(86, 49)(180, 183)(255, 255)B(0, 0)(19, 17)(66, 41)(97, 92)(137, 156)(194, 211)(255, 255)RGB(0, 0)(82, 36)(160, 183)(255, 255) ",
            "@adjust exposure 0.98 ",
            "@adjust colorbalance 0.99 0.52 -0.31 ",
            "@style max",

            "@curve R(0, 0)(71, 74)(164, 165)(255, 255) @pixblend screen 0.94118 0.29 0.29 1 20",//415
            "@curve G(0, 0)(144, 166)(255, 255) @pixblend screen 0.94118 0.29 0.29 1 20",//416
            "@curve B(0, 0)(68, 72)(149, 184)(255, 255) @pixblend screen 0.94118 0.29 0.29 1 20",//417
            "@curve R(0, 0)(71, 74)(164, 165)(255, 255) @pixblend overlay 0.357 0.863 0.882 1 40",//418
            "@curve R(0, 0)(96, 61)(154, 177)(255, 255) @pixblend overlay 0.357 0.863 0.882 1 40",//419
            "@curve R(0, 0)(152, 183)(255, 255)G(0, 0)(161, 133)(255, 255) @pixblend overlay 0.357 0.863 0.882 1 40",//420
            "@curve R(0, 0)(149, 145)(255, 255)G(0, 0)(149, 145)(255, 255)B(0, 0)(149, 145)(255, 255) @pixblend colordodge 0.937 0.482 0.835 1 20",//421
            "@curve G(0, 0)(101, 127)(255, 255) @pixblend colordodge 0.937 0.482 0.835 1 20",//422
            "@curve B(0, 0)(70, 87)(140, 191)(255, 255) @pixblend pinlight 0.247 0.49 0.894 1 20",//423
            "@adjust saturation 0.7 @pixblend screen 0.8112 0.243 1 1 40",//425
            "@adjust saturation 0.7 @pixblend screen 1 0.243 0.69 1 30",//426
            "@curve R(0, 0)(71, 74)(164, 165)(255, 255) @pixblend screen 0.94118 0.29 0.29 1 20",//415
            "@curve G(0, 0)(144, 166)(255, 255) @pixblend screen 0.94118 0.29 0.29 1 20",//416
            "@curve B(0, 0)(68, 72)(149, 184)(255, 255) @pixblend screen 0.94118 0.29 0.29 1 20",//417
            "@curve R(0, 0)(71, 74)(164, 165)(255, 255) @pixblend overlay 0.357 0.863 0.882 1 40",//418
            "@curve R(0, 0)(96, 61)(154, 177)(255, 255) @pixblend overlay 0.357 0.863 0.882 1 40",//419
            "@curve R(0, 0)(152, 183)(255, 255)G(0, 0)(161, 133)(255, 255) @pixblend overlay 0.357 0.863 0.882 1 40",//420
            "@curve R(0, 0)(149, 145)(255, 255)G(0, 0)(149, 145)(255, 255)B(0, 0)(149, 145)(255, 255) @pixblend colordodge 0.937 0.482 0.835 1 20",//421
            "@curve G(0, 0)(101, 127)(255, 255) @pixblend colordodge 0.937 0.482 0.835 1 20",//422
            "@curve B(0, 0)(70, 87)(140, 191)(255, 255) @pixblend pinlight 0.247 0.49 0.894 1 20",//423
            "@adjust saturation 0.7 @pixblend screen 0.8112 0.243 1 1 40",//425
            "@adjust saturation 0.7 @pixblend screen 1 0.243 0.69 1 30",//426
            "@curve R(0, 0)(117, 95)(155, 171)(179, 225)(255, 255)G(0, 0)(94, 66)(155, 176)(255, 255)B(0, 0)(48, 59)(141, 130)(255, 224)",//5

            "@curve R(0, 0)(69, 63)(105, 138)(151, 222)(255, 255)G(0, 0)(67, 51)(135, 191)(255, 255)B(0, 0)(86, 76)(150, 212)(255, 255)",//6
            "@curve R(0, 0)(43, 77)(56, 104)(100, 166)(255, 255)G(0, 0)(35, 53)(255, 255)B(0, 0)(110, 123)(255, 212)",//7
            "@curve R(0, 0)(35, 71)(153, 197)(255, 255)G(0, 15)(16, 36)(109, 132)(255, 255)B(0, 23)(181, 194)(255, 230)",//8
            "@curve R(15, 0)(92, 133)(255, 234)G(0, 20)(105, 128)(255, 255)B(0, 0)(120, 132)(255, 214)",//9
            "@curve R(0, 4)(255, 244)G(0, 0)(255, 255)B(0, 84)(255, 194)",//10
            "@curve R(48, 56)(82, 129)(130, 206)(214, 255)G(7, 37)(64, 111)(140, 190)(232, 220)B(2, 97)(114, 153)(229, 172)",//11
            "@curve R(39, 0)(93, 61)(130, 136)(162, 193)(208, 255)G(41, 0)(92, 61)(128, 133)(164, 197)(200, 250)B(0, 23)(125, 127)(255, 230)",//12
            "@curve R(40, 162)(108, 186)(142, 208)(193, 227)(239, 249)G(13, 7)(72, 87)(124, 150)(197, 206)(255, 255)B(8, 22)(57, 97)(112, 147)(184, 204)(255, 222)",//13
            "@curve R(5, 49)(85, 173)(184, 249)G(23, 35)(65, 76)(129, 145)(255, 199)B(74, 69)(158, 107)(255, 126)",//15
            "@adjust hsv -0.7 -0.7 0.5 -0.7 -0.7 0.5 @pixblend ol 0.243 0.07059 0.59215 1 25",//17
            "@adjust hsv -0.4 -0.64 -1.0 -0.4 -0.88 -0.88 @curve R(0, 0)(119, 160)(255, 255)G(0, 0)(83, 65)(163, 170)(255, 255)B(0, 0)(147, 131)(255, 255)",//22
            "@curve R(40, 40)(86, 148)(255, 255)G(0, 28)(67, 140)(142, 214)(255, 255)B(0, 100)(103, 176)(195, 174)(255, 255) @adjust hsv 0.32 0 -0.5 -0.2 0 -0.4",//25
            "@curve R(4, 35)(65, 82)(117, 148)(153, 208)(206, 255)G(13, 5)(74, 78)(109, 144)(156, 201)(250, 250)B(6, 37)(93, 104)(163, 184)(238, 222)(255, 237) @adjust hsv -0.2 -0.2 -0.44 -0.2 -0.2 -0.2",//26
            "@curve R(0, 4)(39, 103)(134, 223)(242, 255)G(0, 3)(31, 85)(68, 155)(131, 255)(219, 255)B(0, 3)(42, 110)(114, 207)(255, 255)",//162
            "@curve R(5, 8)(36, 51)(115, 145)(201, 220)(255, 255)G(6, 9)(67, 83)(169, 190)(255, 255)B(3, 3)(55, 60)(177, 190)(255, 255)",//166
            "@curve R(0, 0)(69, 93)(126, 160)(210, 232)(255, 255)G(0, 0)(36, 47)(135, 169)(250, 254)B(0, 0)(28, 30)(107, 137)(147, 206)(255, 255)",//169
            "@curve R(2, 2)(16, 30)(72, 112)(135, 185)(252, 255)G(2, 1)(30, 42)(55, 84)(157, 207)(238, 249)B(1, 0)(26, 17)(67, 106)(114, 165)(231, 250)",//170
            "@curve R(16, 0)(60, 45)(124, 124)(214, 255)G(18, 2)(91, 81)(156, 169)(213, 255)B(16, 0)(85, 74)(158, 171)(211, 255) @curve R(17, 0)(144, 150)(214, 255)G(16, 0)(61, 47)(160, 172)(215, 255)B(21, 2)(131, 135)(213, 255)",//171
            "@curve R(0, 0)(135, 147)(255, 255)G(0, 0)(135, 147)(255, 255)B(0, 0)(135, 147)(255, 255)  @adjust saturation 0.71 @adjust brightness -0.05 @curve R(19, 0)(45, 36)(88, 90)(130, 125)(200, 170)(255, 255)G(18, 0)(39, 26)(71, 74)(147, 160)(255, 255)B(0, 0)(77, 58)(136, 132)(255, 204)",//300
            "@curve R(42, 2)(53, 52)(80, 102)(100, 123)(189, 196)(255, 255)G(55, 74)(75, 98)(95, 114)(177, 197)(203, 212)(221, 220)(229, 234)(240, 249)B(0, 132)(81, 188)(180, 251)",//303
            "@adjust saturation 0 @curve R(0, 68)(10, 72)(42, 135)(72, 177)(98, 201)(220, 255)G(0, 29)(12, 30)(57, 127)(119, 203)(212, 255)(254, 239)B(0, 36)(54, 118)(66, 141)(119, 197)(155, 215)(255, 254)",//304
            "@curve R(0, 64)(16, 13)(58, 128)(108, 109)(162, 223)(255, 255)G(0, 30)(22, 35)(42, 58)(56, 86)(70, 119)(130, 184)(189, 212)B(6, 36)(76, 157)(107, 192)(173, 229)(255, 255)", //306
            "@vigblend mix 10 10 30 255 91 0 1.0 0.5 0.5 3 @curve R(0, 31)(35, 75)(81, 139)(109, 174)(148, 207)(255, 255)G(0, 24)(59, 88)(105, 146)(130, 171)(145, 187)(180, 214)(255, 255)B(0, 96)(63, 130)(103, 157)(169, 194)(255, 255)",
            "@adjust saturation 0 @curve R(0, 49)(16, 44)(34, 56)(74, 120)(120, 185)(151, 223)(255, 255)G(0, 46)(34, 73)(85, 129)(111, 164)(138, 192)(170, 215)(255, 255)B(0, 77)(51, 101)(105, 143)(165, 182)(210, 213)(250, 229)",
            "@adjust saturation 0 @adjust level 0 0.83921 0.8772",
            "@adjust hsl 0.02 -0.31 -0.17 @curve R(0, 28)(23, 45)(117, 148)(135, 162)G(0, 8)(131, 152)(255, 255)B(0, 17)(58, 80)(132, 131)(127, 131)(255, 225)"
    };

    public static List getListFilter() {
        List<Filter> listFilter = new ArrayList<>();
        listFilter.add(new Filter("Normal", FilterConfig.EFFECT_CONFIGS[0], R.drawable.a10));
        listFilter.add(new Filter("Beautify", FilterConfig.EFFECT_CONFIGS[1], R.drawable.a11));
        listFilter.add(new Filter("Curve 1", FilterConfig.EFFECT_CONFIGS[2], R.drawable.a12));
        listFilter.add(new Filter("Edgy ", FilterConfig.EFFECT_CONFIGS[3], R.drawable.a13));
        listFilter.add(new Filter("Film ", FilterConfig.EFFECT_CONFIGS[4], R.drawable.a14));
        listFilter.add(new Filter("Foggy ", FilterConfig.EFFECT_CONFIGS[5], R.drawable.a15));
        listFilter.add(new Filter("Late ", FilterConfig.EFFECT_CONFIGS[6], R.drawable.a16));
        listFilter.add(new Filter("Warming", FilterConfig.EFFECT_CONFIGS[7], R.drawable.a17));
        listFilter.add(new Filter("WildBird", FilterConfig.EFFECT_CONFIGS[8], R.drawable.a18));
        listFilter.add(new Filter("Blur Lerp", FilterConfig.EFFECT_CONFIGS[9], R.drawable.a19));
        listFilter.add(new Filter("Sketch", FilterConfig.EFFECT_CONFIGS[10], R.drawable.a110));
        listFilter.add(new Filter("Colorful 1", FilterConfig.EFFECT_CONFIGS[11], R.drawable.a111));
        listFilter.add(new Filter("Colorful 2", FilterConfig.EFFECT_CONFIGS[12], R.drawable.a112));
        listFilter.add(new Filter("Colorful 3", FilterConfig.EFFECT_CONFIGS[13], R.drawable.a113));
        listFilter.add(new Filter("Colorful 4", FilterConfig.EFFECT_CONFIGS[14], R.drawable.a114));
        listFilter.add(new Filter("Crosshatch", FilterConfig.EFFECT_CONFIGS[15], R.drawable.a115));
        listFilter.add(new Filter("Edge 1", FilterConfig.EFFECT_CONFIGS[16], R.drawable.a116));
        listFilter.add(new Filter("Edge  2", FilterConfig.EFFECT_CONFIGS[17], R.drawable.a117));
        listFilter.add(new Filter("Vigblend", FilterConfig.EFFECT_CONFIGS[18], R.drawable.a118));
        listFilter.add(new Filter("Curve 3", FilterConfig.EFFECT_CONFIGS[19], R.drawable.a119));
        listFilter.add(new Filter("Exposure", FilterConfig.EFFECT_CONFIGS[20], R.drawable.a120));
        listFilter.add(new Filter("Blance", FilterConfig.EFFECT_CONFIGS[21], R.drawable.a121));
        listFilter.add(new Filter("Max", FilterConfig.EFFECT_CONFIGS[22], R.drawable.a122));


        listFilter.add(new Filter("Curve 4", FilterConfig.EFFECT_CONFIGS[23], R.drawable.a223));
        listFilter.add(new Filter("Curve 5", FilterConfig.EFFECT_CONFIGS[24], R.drawable.a224));
        listFilter.add(new Filter("Curve 6", FilterConfig.EFFECT_CONFIGS[25], R.drawable.a225));
        listFilter.add(new Filter("Curve 7", FilterConfig.EFFECT_CONFIGS[26], R.drawable.a226));
        listFilter.add(new Filter("Curve 8", FilterConfig.EFFECT_CONFIGS[27], R.drawable.a227));
        listFilter.add(new Filter("Curve 9", FilterConfig.EFFECT_CONFIGS[28], R.drawable.a228));
        listFilter.add(new Filter("Curve 10", FilterConfig.EFFECT_CONFIGS[29], R.drawable.a229));
        listFilter.add(new Filter("Curve 11", FilterConfig.EFFECT_CONFIGS[30], R.drawable.a230));
        listFilter.add(new Filter("Curve 12", FilterConfig.EFFECT_CONFIGS[31], R.drawable.a231));
        listFilter.add(new Filter("Curve 13", FilterConfig.EFFECT_CONFIGS[32], R.drawable.a232));
        listFilter.add(new Filter("Curve 14", FilterConfig.EFFECT_CONFIGS[33], R.drawable.a233));
        listFilter.add(new Filter("Curve 15", FilterConfig.EFFECT_CONFIGS[34], R.drawable.a234));
        listFilter.add(new Filter("Curve 16", FilterConfig.EFFECT_CONFIGS[35], R.drawable.a235));
        listFilter.add(new Filter("Curve 17", FilterConfig.EFFECT_CONFIGS[36], R.drawable.a236));
        listFilter.add(new Filter("Curve 18", FilterConfig.EFFECT_CONFIGS[37], R.drawable.a237));
        listFilter.add(new Filter("Curve 19", FilterConfig.EFFECT_CONFIGS[38], R.drawable.a238));
        listFilter.add(new Filter("Curve 20", FilterConfig.EFFECT_CONFIGS[39], R.drawable.a239));
        listFilter.add(new Filter("Curve 21", FilterConfig.EFFECT_CONFIGS[40], R.drawable.a240));
        listFilter.add(new Filter("Curve 22", FilterConfig.EFFECT_CONFIGS[41], R.drawable.a241));
        listFilter.add(new Filter("Curve 23", FilterConfig.EFFECT_CONFIGS[42], R.drawable.a242));
        listFilter.add(new Filter("Curve 24", FilterConfig.EFFECT_CONFIGS[43], R.drawable.a243));
        listFilter.add(new Filter("Curve 25", FilterConfig.EFFECT_CONFIGS[44], R.drawable.a244));
        listFilter.add(new Filter("Curve 26", FilterConfig.EFFECT_CONFIGS[45], R.drawable.a245));

        listFilter.add(new Filter("Curve 27", FilterConfig.EFFECT_CONFIGS[46], R.drawable.a346));
        listFilter.add(new Filter("Curve 28", FilterConfig.EFFECT_CONFIGS[47], R.drawable.a347));
        listFilter.add(new Filter("Curve 29", FilterConfig.EFFECT_CONFIGS[48], R.drawable.a348));
        listFilter.add(new Filter("Curve 30", FilterConfig.EFFECT_CONFIGS[49], R.drawable.a349));
        listFilter.add(new Filter("Curve 31", FilterConfig.EFFECT_CONFIGS[50], R.drawable.a350));
        listFilter.add(new Filter("Curve 32", FilterConfig.EFFECT_CONFIGS[51], R.drawable.a351));
        listFilter.add(new Filter("Curve 33", FilterConfig.EFFECT_CONFIGS[52], R.drawable.a352));
        listFilter.add(new Filter("Curve 34", FilterConfig.EFFECT_CONFIGS[53], R.drawable.a353));
        listFilter.add(new Filter("Curve 35", FilterConfig.EFFECT_CONFIGS[54], R.drawable.a354));
        listFilter.add(new Filter("Curve 36", FilterConfig.EFFECT_CONFIGS[55], R.drawable.a355));
        listFilter.add(new Filter("Curve 37", FilterConfig.EFFECT_CONFIGS[56], R.drawable.a356));
        listFilter.add(new Filter("Curve 38", FilterConfig.EFFECT_CONFIGS[57], R.drawable.a357));
        listFilter.add(new Filter("Curve 39", FilterConfig.EFFECT_CONFIGS[58], R.drawable.a358));
        listFilter.add(new Filter("Curve 40", FilterConfig.EFFECT_CONFIGS[59], R.drawable.a359));
        listFilter.add(new Filter("Curve 41", FilterConfig.EFFECT_CONFIGS[60], R.drawable.a360));
        listFilter.add(new Filter("Curve 42", FilterConfig.EFFECT_CONFIGS[61], R.drawable.a361));
        listFilter.add(new Filter("Curve 43", FilterConfig.EFFECT_CONFIGS[62], R.drawable.a362));
        listFilter.add(new Filter("Curve 44", FilterConfig.EFFECT_CONFIGS[63], R.drawable.a363));
        listFilter.add(new Filter("Curve 45", FilterConfig.EFFECT_CONFIGS[64], R.drawable.a364));
        listFilter.add(new Filter("Curve 46", FilterConfig.EFFECT_CONFIGS[65], R.drawable.a365));
        listFilter.add(new Filter("Curve 47", FilterConfig.EFFECT_CONFIGS[66], R.drawable.a366));
        listFilter.add(new Filter("Curve 48", FilterConfig.EFFECT_CONFIGS[67], R.drawable.a367));
        listFilter.add(new Filter("Curve 49", FilterConfig.EFFECT_CONFIGS[68], R.drawable.a368));
        listFilter.add(new Filter("Curve 50", FilterConfig.EFFECT_CONFIGS[69], R.drawable.a369));
        listFilter.add(new Filter("Curve 51", FilterConfig.EFFECT_CONFIGS[70], R.drawable.a370));
        listFilter.add(new Filter("Curve 52", FilterConfig.EFFECT_CONFIGS[71], R.drawable.a371));
        return listFilter;
    }

    public void processFilter(Bitmap bitmap, String config) {
        new ProcessFilter(listener, config).execute(bitmap);
    }

    public Bitmap processBitmap(Bitmap bitmap, String config){
        return CGENativeLibrary.filterImage_MultipleEffects(bitmap, config, 1);
    }

    public class ProcessFilter extends AsyncTask<Bitmap, Void, Bitmap> {
        private String config;
        private OnBitmapListener listener;


        public ProcessFilter(OnBitmapListener listener, String config) {
            this.config = config;
            this.listener = listener;
        }

        @Override
        protected Bitmap doInBackground(Bitmap... bitmaps) {
            return CGENativeLibrary.filterImage_MultipleEffects(bitmaps[0], config, 1);

        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            listener.onBitmapReturn(bitmap);
        }
    }


}
