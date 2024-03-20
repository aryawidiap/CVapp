package com.example.cvapp.education

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cvapp.R

/**
 * A simple [Fragment] subclass.
 * Use the [EducationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EducationFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var RvCv : RecyclerView? = null
    var adapter : EducationAdapter? = null
    var items : MutableList<EducationItem> = mutableListOf<EducationItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_education, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        RvCv = view.findViewById(R.id.recyclerview_cv)

        // Create a list of Education Items
        items.add(EducationItem("Asia University", "Double Degree - Computer Science and Information Engineering (2023-sekarang)"))
        items.add(EducationItem("Universiti Teknologi Malaysia", "Pertukaran Pelajar (IISMA 2022) - School of Computing\n(Semester Ganjil 2022)"))
        items.add(EducationItem("Institut Teknologi Sepuluh Nopember", "Strata 1 - Teknik Informatika (2020-sekarang)"))
        items.add(EducationItem("SMA N 4 Denpasar", "Jurusan MIPA (2017-2020)"))

        adapter = EducationAdapter(items)
        RvCv?.layoutManager = LinearLayoutManager(context)
        RvCv?.adapter = adapter
    }
}