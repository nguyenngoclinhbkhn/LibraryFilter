+ import module LibraryFilter

+  	import 
	implementation 'androidx.recyclerview:recyclerview:1.0.0'
	implementation 'androidx.cardview:cardview:1.0.0'
	in build.gradle (level app) in your project
	
+ in method onCreate() in your activity
	FilterConfig filterConfig = new FilterConfig(this);
+ Decalred AdapterFilter to apply your RecyclerView
+ Implement Method onFilterClicked(), onBitmapReturn()
+ in method onFilterClicked, we will process bitmap with filterConfig.processFilter(bitmap, filter.getConfig());
+ and we will be have a bitmapReturn in method onBitmapReturn()
