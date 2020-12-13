package com.arifahmadalfian.academies.ui.academy

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arifahmadalfian.academies.R
import com.arifahmadalfian.academies.data.CourseEntity
import com.arifahmadalfian.academies.databinding.ItemsAcademyBinding
import com.arifahmadalfian.academies.ui.detail.DetailCourseActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.*

class AcademyAdapter: RecyclerView.Adapter<AcademyAdapter.CourseViewHolder>() {
    private var listCouses = ArrayList<CourseEntity>()

    fun setCourse(courses: List<CourseEntity>?) {
        if (courses == null) return
        this.listCouses.clear()
        this.listCouses.addAll(courses)

        this.notifyDataSetChanged()
    }

    class CourseViewHolder(private val itemsAcademyBinding: ItemsAcademyBinding): RecyclerView.ViewHolder(itemsAcademyBinding.root) {
        fun bind(course: CourseEntity) {
            with(itemsAcademyBinding) {
                tvItemTitle.text = course.title
                tvItemDate.text = itemView.resources.getString(R.string.deadline_date, course.deadline)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailCourseActivity::class.java)
                    intent.putExtra(DetailCourseActivity.EXTRA_COURSE, course.courseId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                        .load(course.imagePath)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                        .error(R.drawable.ic_erorr)
                        .into(imgPoster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val itemsAcademyBinding = ItemsAcademyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(itemsAcademyBinding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = listCouses[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int {
        return listCouses.size
    }
}