    @Override
    public void finish() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            super.finishAndRemoveTask();
        }
        else {
            super.finish();
        }
    }

    private void exitDialog() {
//        this.finish();
//        Intent intent = new Intent(Intent.ACTION_MAIN);
//        intent.addCategory(Intent.CATEGORY_HOME);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
//
//        //background Killing
//        finishAffinity();
//        android.os.Process.killProcess(android.os.Process.myUid());
//
//        android.os.Process.killProcess(android.os.Process.myPid());
//        finishAndRemoveTask();
//        moveTaskToBack(true);
        finish();
    }
