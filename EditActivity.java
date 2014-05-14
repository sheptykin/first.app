package my.training;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends Activity {
	
	// globally accessible application class
    protected DemoApplication app;
    
    protected int [] ids = {
            R.id.editName,
            R.id.editProffession,
            R.id.editMail,
    };
     
	@Override
	    	protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        this.app = (DemoApplication)this.getApplication();
	        
	        this.setContentView(R.layout.edit_main);
	        this.initTextEdits();
	     	     	      	        
	        Button saveButton = (Button) this.findViewById(R.id.save);
	        saveButton.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View view) {
	                // updating values
	                EditActivity.this.updateStringNames();
	                // returning to the previous activity
	                EditActivity.this.finish();
	            }
	        });
	 
	    }
	
			public void updateStringNames(){
		        for(int i = 0; i < this.ids.length; i ++){
		            EditText field = (EditText)this.findViewById(this.ids[i]);
		            String value = field.getText().toString();
		            this.app.screenNames[i] = value;
		        }
		    }
	
	 		public void initTextEdits(){
		        for(int i = 0; i < this.ids.length; i ++){
		            String value = this.app.screenNames[i];
		            EditText field = (EditText)this.findViewById(this.ids[i]);
		            field.setText(value);
		        }
	    }
	}


