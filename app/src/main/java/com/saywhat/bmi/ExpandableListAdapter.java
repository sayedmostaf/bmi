package com.saywhat.bmi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private String[] groupHeaders;
    private String[][] childItems;

    public ExpandableListAdapter(Context context, String[] groupHeaders, String[][] childItems) {
        this.context = context;
        this.groupHeaders = groupHeaders;
        this.childItems = childItems;
    }

    @Override
    public int getGroupCount() {
        return groupHeaders.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childItems[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupHeaders[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childItems[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.group_option_causes, null);
        TextView groupNameTextView = view.findViewById(R.id.group_name);
        groupNameTextView.setText(groupHeaders[groupPosition]);

        ImageView arrowImageView = view.findViewById(R.id.arrow);
        if (isExpanded) {
            arrowImageView.setImageResource(android.R.drawable.arrow_up_float);
        } else {
            arrowImageView.setImageResource(android.R.drawable.arrow_down_float);
        }
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.child_option_causes, null);
        CheckBox childCheckBox = view.findViewById(R.id.child_checkbox);
        childCheckBox.setText(childItems[groupPosition][childPosition]);

        childCheckBox.setChecked(false);

        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}