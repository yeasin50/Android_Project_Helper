<h3> simple way to create pdf on android  using canvas.</h3>

<h2>add permision on manifest file. 
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>

Request for permission onCreate 
  //permission
        ActivityCompat.requestPermissions(this, new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE},PackageManager.PERMISSION_GRANTED);

</h2>

