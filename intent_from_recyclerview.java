public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        final String B_Name = batches.get(position).getBatchName();
        holder.batchView.setText(B_Name);
        holder.batchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), Attendence_Sheet.class);
                intent.putExtra("BATCH", B_Name);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }
