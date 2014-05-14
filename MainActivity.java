package my.training;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	  int[] layouts = {
	            R.layout.activity_main, //лейаут де змінюється інфа
	            R.layout.back_main,
	            R.layout.third_main
	    };

	    int layoutIndex = 0;

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        this.displayScreen(this.layouts[this.layoutIndex]);
	        this.switchLayout();
	    }

	    protected void switchLayout(){
	    	 
	        this.layoutIndex ++;
	 
	        // loop from the beginning
	        if(this.layoutIndex >= this.layouts.length){
	            this.layoutIndex = 0;
	        }
	       
	 
	        this.displayScreen(this.layouts[this.layoutIndex]);
	 
	    }

	    protected void displayScreen(int id){
	    	 
	        setContentView(id);
	 
	        Button b = (Button)this.findViewById(R.id.next);
	        b.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View view) {
	                MainActivity.this.switchLayout();
	            }
	        });
	        
	        if(id==R.layout.activity_main) //тому що зміюю інфу лише в цьому лейауті
		        {
		        DemoApplication app = (DemoApplication) this.getApplication();
		       
		        String name = app.screenNames[0];
		        TextView nameView = (TextView) this.findViewById(R.id.textView1);
		        nameView.setText(name);
		        
		        String proffession = app.screenNames[1];
		        TextView proffessionView = (TextView) this.findViewById(R.id.textView2);
		        proffessionView.setText(proffession);
		        
		        String mail = app.screenNames[2];
		        TextView mailView = (TextView) this.findViewById(R.id.textView3);
		        mailView.setText(mail);
		        }
		        
	        
	    }
	    
    @Override
    protected void onResume() {
        super.onResume();
        this.displayScreen(this.layouts[this.layoutIndex]);
    }
	 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
 
            Intent i = new Intent(this, EditActivity.class);
            this.startActivity(i);
 
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
