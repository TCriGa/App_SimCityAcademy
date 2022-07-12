package br.com.zup.simcityacademy.ui.avggrades.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.com.zup.simcityacademy.databinding.ActivityGradeAvgBinding
import br.com.zup.simcityacademy.domain.model.Bimester
import br.com.zup.simcityacademy.ui.avggrades.viewmodel.GradeAVGViewModel

class GradeAVGActivity : AppCompatActivity() {
    private val viewModel: GradeAVGViewModel by lazy {
        ViewModelProvider(this)[GradeAVGViewModel::class.java]
    }
    private lateinit var binding: ActivityGradeAvgBinding
    var type: Int = 1

    companion object {
        fun newInstance(type: Int): GradeAVGActivity {
            return GradeAVGActivity().apply {
                this.type = type
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGradeAvgBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


}