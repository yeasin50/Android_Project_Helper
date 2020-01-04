Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int mon = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),
                (DatePickerDialog.OnDateSetListener) getActivity(),
                year,mon,day);
                
// or 
 Calendar calendar =Calendar.getInstance();
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a  dd-MM-yyyy");
String dateTime =  simpleDateFormat.format(calendar.getTime());
