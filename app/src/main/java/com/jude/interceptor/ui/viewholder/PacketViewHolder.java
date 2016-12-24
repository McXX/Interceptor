package com.jude.interceptor.ui.viewholder;

import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.interceptor.R;
import com.jude.interceptor.domain.entities.PacketItem;
import com.jude.interceptor.utils.SizeFormat;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PacketViewHolder extends BaseViewHolder<PacketItem> {
    @Bind(R.id.tv_type)
    TextView tvType;
    @Bind(R.id.tv_address_from)
    TextView tvAddressFrom;
    @Bind(R.id.tv_address_to)
    TextView tvAddressTo;
    @Bind(R.id.tv_size)
    TextView tvSize;
    @Bind(R.id.tv_data)
    TextView tvData;
    @Bind(R.id.item_field)
    LinearLayout layout;

    public PacketViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_packet);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setData(PacketItem data) {
        switch (data.getType()){
            case PacketItem.TCP:
                tvType.setText(R.string.TCP);
                layout.setBackgroundColor(Color.parseColor("#43A047"));
                break;
            case PacketItem.UDP:
                tvType.setText(R.string.UDP);
                layout.setBackgroundColor(Color.parseColor("#1E88E5"));
                break;
            case PacketItem.HTTP:
                tvType.setText(R.string.HTTP);
                layout.setBackgroundColor(Color.parseColor("#1565C0"));
                break;
            case PacketItem.Telnet:
                tvType.setText(R.string.Telnet);
                layout.setBackgroundColor(Color.RED);
                break;
            case PacketItem.ARP:
                tvType.setText(R.string.ARP);
                break;
            case PacketItem.UNKNOW:
                tvType.setText(R.string.other);
                layout.setBackgroundColor(Color.GRAY);
                break;
        }

        tvAddressFrom.setText(data.getSip()+":"+data.getSport());
        tvAddressFrom.setTextColor(Color.WHITE);
        tvAddressTo.setText(data.getDip()+":"+data.getDport());
        tvAddressTo.setTextColor(Color.WHITE);
        tvSize.setText(SizeFormat.convertToStringRepresentation(data.getLength()));
        tvSize.setTextColor(Color.WHITE);
        tvType.setTextColor(Color.WHITE);
        tvData.setText(data.getData());
    }
}
