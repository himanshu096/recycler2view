package home.imanshu.in.test05;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private CustomAdapter mAdapter;
    private ArrayList<String> mPostList;
    private LinearLayoutManager mLayoutManager;
    RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mPostList=new ArrayList<String>();
        mPostList.add(0,"fjsbndfskjbndiu");
        mPostList.add(1,"efjdlsafdbgddfskjbndiu");
        mPostList.add(2,"5784zdvklkjbndiu");
        mPostList.add(3,"fjsbndfskjbndiu");
        mPostList.add(4,"kjsfnkjbndiu");
        mPostList.add(5,"jdvnhdi");
        mPostList.add(6,"sdkjvhidosl");
        mPostList.add(7,"sdkjlvnkldsj");
        mPostList.add(8,"skjdvnfsklnsk;");
        mPostList.add(9,"skjdvnfsklnsk;");
        mPostList.add(10,"skjdvnfsklnsk;");
        mPostList.add(11,"skjdvnfsklnsk;");
        mPostList.add(12,"skjdvnfsklnsk;");
        mPostList.add(13,"skjdvnfsklnsk;");
        mPostList.add(14,"skjdvnfsklnsk;");
        mPostList.add(15,"skjdvnfsklnsk;");



        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new CustomAdapter(MainActivity.this, mPostList);
        mRecyclerView.setAdapter(mAdapter);
    }











    //View Holder Class
    public class CustomViewHolder extends RecyclerView.ViewHolder {


        TextView mTextView;


        public CustomViewHolder(View itemView) {
            super(itemView);

        }




    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {


        TextView mTextView,mTextView2;

        public ViewHolder2(View itemView) {
            super(itemView);

            mTextView=(TextView)itemView.findViewById(R.id.view_holder_custom_text_view2);
            mTextView2=(TextView)itemView.findViewById(R.id.text02);
        }


    }



    //Adapter Class
    public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



        private final int USER = 0, IMAGE = 1;
        private List<String> dataList;
        private LayoutInflater inflater;

        public CustomAdapter(Context context, List<String> dataList) {
            inflater = LayoutInflater.from(context);
            this.dataList = dataList;
        }


        @Override
        public int getItemViewType(int position) {
            if (position==4 || position==10 ) {
                return USER;
            } else  {
                return IMAGE;
            }

        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            //More to come
            RecyclerView.ViewHolder viewHolder;
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

            switch (viewType){

                case USER:
                    View v1 = inflater.inflate(R.layout.view_holder_custom, viewGroup, false);
                    viewHolder = new CustomViewHolder(v1);
                    break;
                case IMAGE:
                    View v2 = inflater.inflate(R.layout.view_holder_custom2, viewGroup, false);
                    viewHolder = new ViewHolder2(v2);
                    break;
                default:
                    View v = inflater.inflate(R.layout.view_holder_custom, viewGroup, false);
                    viewHolder = new CustomViewHolder(v);
                    break;

            }
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            switch (holder.getItemViewType()) {
                case USER:
                    CustomViewHolder vh1 = (CustomViewHolder) holder;
                    configureViewHolder1(vh1, position);
                    break;
                case IMAGE:
                    ViewHolder2 vh2 = (ViewHolder2) holder;
                    configureViewHolder2(vh2, position);
                    break;
                default:
                    CustomViewHolder vh = (CustomViewHolder) holder;
                    configureDefaultViewHolder(vh, position);
                    break;
            }

        }



        private void configureDefaultViewHolder(CustomViewHolder vh, int position) {
            vh.mTextView.setText("its Default");
        }

        private void configureViewHolder1(CustomViewHolder vh1, int position) {
//           vh1.mTextView.setText("its 1 holder");
        }

        private void configureViewHolder2(ViewHolder2 vh2,int position) {
            vh2.mTextView.setText("I knew him fairly well before the film. While making the movie, I got a chance to observe him closely. Once he agreed to the biopic, he was very honest and patient, answering all the questions. He remained equally involved throughout the project and while promoting the film.\n" +
                    "\n" +
                    "But if you ask me how well I know him beyond the film, I have to say, very little.");
            vh2.mTextView2.setText("my notice"+position);
        }



        @Override
        public int getItemCount() {
            return dataList.size();
        }
    }

}




