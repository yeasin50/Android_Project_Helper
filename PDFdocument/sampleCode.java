
/*also check Manifest storage permisio
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
*/

public class MainActivity extends AppCompatActivity {

    int docWidth =  250, docHieght = 400 ;

    String [] fields = new String[]{"Name", "Gender", "Address", "Phone", "Email"};

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //permission
        ActivityCompat.requestPermissions(this, new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE},PackageManager.PERMISSION_GRANTED);

       creatPDF();

    }
//Todo: this holds everything 
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void creatPDF() {
        PdfDocument document = new PdfDocument();
        Paint paint = new Paint();


        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(docWidth,docHieght,1).create();
        PdfDocument.Page page1= document.startPage(pageInfo);

        Canvas canvas = page1.getCanvas();


        //header
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(Color.BLUE);
        paint.setTextSize(12.0f);
        canvas.drawText("Amigo Project", pageInfo.getPageWidth()/2,30, paint);

        //sub header
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(Color.BLACK);
        paint.setTextSize(8.0f);
        canvas.drawText("here My address Agimo enter price", pageInfo.getPageWidth()/2, 50,paint);

        // Title
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTextSize(10.0f);
        paint.setColor(Color.GRAY);
        canvas.drawText("Amigo's Details here", 10,70,paint);


        /// Fileds
        paint.setTextSize(8.0f);
        paint.setColor(Color.BLACK);
        int initYFiledPosition = 90;

        canvas.drawLine(7, 80, pageInfo.getPageWidth()-10,80,paint);
        for (int i=0 ; i<5; i++){
            canvas.drawLine(7, initYFiledPosition+3, pageInfo.getPageWidth()-10,initYFiledPosition+4,paint);
            canvas.drawText(fields[i],10,initYFiledPosition, paint);
            initYFiledPosition+=17;
        }
        //vertical lines
        canvas.drawLine(48,80,48,initYFiledPosition-14,paint);
        canvas.drawLine(7,80,7,initYFiledPosition-14,paint);
//        paint.setColor(Color.RED);
        canvas.drawLine(pageInfo.getPageWidth()-10,80,pageInfo.getPageWidth()-10,initYFiledPosition-13,paint);


        //Photo frame
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);

        canvas.drawRect(10,200,pageInfo.getPageWidth()-10, 300, paint);
        canvas.drawLine(85, 200,85, 300, paint);
        canvas.drawLine(163, 200,163, 300, paint);

        paint.setStrokeWidth(0);
        paint.setColor(Color.DKGRAY);
        paint.setStyle(Paint.Style.FILL);

        canvas.drawText("Photo",35,250,paint);
        paint.setColor(Color.RED);
        canvas.drawText("Photo",110,250,paint);
        paint.setColor(Color.DKGRAY);
        canvas.drawText("Photo",190,250,paint);

        canvas.drawText("Notes ",10,320,paint);


        document.finishPage(page1);
        File file = new File(Environment.getExternalStorageDirectory(),"Hellow.pdf");
        try{
            document.writeTo(new FileOutputStream(file));
        }catch (IOException e){
            e.printStackTrace();
        }

        document.close();

    }
}
