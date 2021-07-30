package com.arteriatech.emami.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.arteriatech.mutils.common.OfflineODataStoreException;
import com.arteriatech.mutils.log.LogManager;
import com.arteriatech.emami.common.Constants;
import com.arteriatech.emami.mbo.DocumentsBean;
import com.arteriatech.emami.msecsales.R;
import com.arteriatech.emami.store.OfflineManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by e10763 on 2/27/2017.
 */

public class VideosAdapter extends ArrayAdapter<DocumentsBean> {

    private Context mContext;
    private ArrayList<DocumentsBean> retVideoValues;
    private final int[] videoId;
    byte[] videoByteArray = null;

    public VideosAdapter(Context context, ArrayList<DocumentsBean> allVideoList, int[] videoId) {
        super(context, R.layout.layout_video_single, allVideoList);
        this.videoId = videoId;
        this.mContext = context;
        this.retVideoValues = allVideoList;


    }

    @Override
    public int getCount() {
        return this.retVideoValues != null ? this.retVideoValues.size() : 0;
    }

    @Override
    public DocumentsBean getItem(int item) {
        DocumentsBean documentsBean;
        documentsBean = this.retVideoValues != null ? this.retVideoValues.get(item) : null;
        return documentsBean;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.layout_video_single, null);

        } else {
            grid = (View) convertView;
        }
        final DocumentsBean documentsBean = retVideoValues.get(position);
        TextView textView = (TextView) grid.findViewById(R.id.grid_text);
        ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
        textView.setText(documentsBean.getFileName().toLowerCase());
        if (Constants.MimeTypeMP4.equalsIgnoreCase(documentsBean.getDocumentMimeType())) {
            imageView.setImageResource(videoId[0]);
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getVideoDetails(documentsBean.getMediaLink(), documentsBean.getDocumentMimeType(), documentsBean.getFileName().toLowerCase());
            }
        });
        return grid;
    }

    private void getVideoDetails(String mStrImagePath, String mimeType, String filename) {
        try {
            videoByteArray = OfflineManager.getImageList(mStrImagePath);
            if (videoByteArray != null) {
                if (Constants.MimeTypeMP4.equalsIgnoreCase(mimeType)) {
                    try {
                        File myDirectory = new File(Environment.getExternalStorageDirectory(), Constants.FolderName);
                        if (!myDirectory.exists()) {
                            myDirectory.mkdirs();
                        }

                        File data = new File(myDirectory, "/" + filename);

                        OutputStream op = new FileOutputStream(data);
                        op.write(videoByteArray);
                        System.out.println("File Created");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        System.out.println("Excep:" + ex.toString());
                    }

                    File dir = Environment.getExternalStorageDirectory();
                    File file = new File(dir + "/" + Constants.FolderName + "/" + filename);
                    file.setReadable(true, false);
                    String videoResource = file.getPath();
                    Uri intentUri = Uri.fromFile(new File(videoResource));
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setDataAndType(intentUri, "video/mp4");
                    try {
                        mContext.startActivity(intent);
                    } catch (Exception ex) {
                        Toast.makeText(mContext, "You may not have a proper app for viewing this content ", Toast.LENGTH_LONG).show();
                    }

                }
            }
        } catch (OfflineODataStoreException e) {
            LogManager.writeLogError(Constants.error_txt + e.getMessage());
        }

    }
}
