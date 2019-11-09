private void showAlertDialog() {

        int month = Calendar.getInstance().get(Calendar.MONTH);
        final int year = Calendar.getInstance().get(Calendar.YEAR);
        final String Mon[] = {"January", "February", "March", "April", "May","June", "July", "August", "September", "October","November", "December"};

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialogmonyear);

        Button setbtn = dialog.findViewById(R.id.diabutton2setMon);
        Button cancelbtn = dialog.findViewById(R.id.diabutton1cancelmon);

        final NumberPicker monthPicker = dialog.findViewById(R.id.numberPicker1Mon);
        monthPicker.setMinValue(0);
        monthPicker.setMaxValue(Mon.length -1);
        monthPicker.setValue(month);
        monthPicker.setDisplayedValues(Mon);
        monthPicker.setWrapSelectorWheel(false);
        monthPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);


        NumberPicker yearPicker = dialog.findViewById(R.id.numberPickerYear);
        yearPicker.setMinValue(year-50);
        yearPicker.setMaxValue(year+50);
        yearPicker.setValue(year);
        yearPicker.setWrapSelectorWheel(false);
        yearPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        setbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int m = monthPicker.getValue();
                Toast.makeText(getApplicationContext(), m+1 +" "+ Mon[m] + " "+ year, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();


    }
