 private void ShowDialog() {

        final EditText editText= new EditText(this);
        editText.setHint("Course section");
        editText.setHintTextColor(getResources().getColor(R.color.hint));

       AlertDialog alertDialog = new AlertDialog.Builder(this)
               .setTitle("Create Batch")
               .setView(editText)
               .setPositiveButton("Create",null)
               .setNegativeButton("Cancel", null)
               .create();

       alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
           @Override
           public void onShow(DialogInterface dialog) {
               Button possbtn = ((AlertDialog)dialog).getButton(DialogInterface.BUTTON_POSITIVE);
               Button negbtn = ((AlertDialog) dialog).getButton(DialogInterface.BUTTON_NEGATIVE);

               possbtn.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       // anything here 
                       Log.i(TAG, "onClick: "+ "poss btn");
                   }
               });
               negbtn.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       // 
                       Log.i(TAG, "onClick: "+ "neg btn");
                   }
               });
           }
       });
       alertDialog.show();
    }
