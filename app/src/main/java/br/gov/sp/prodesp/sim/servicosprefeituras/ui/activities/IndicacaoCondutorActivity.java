package br.gov.sp.prodesp.sim.servicosprefeituras.ui.activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.Date;

import br.gov.sp.prodesp.sim.servicosprefeituras.R;
import br.gov.sp.prodesp.sim.servicosprefeituras.ui.dialogs.Alert;
import br.gov.sp.prodesp.sim.servicosprefeituras.utils.AppUtils;
import br.gov.sp.prodesp.sim.servicosprefeituras.utils.CameraUtils;
import br.gov.sp.prodesp.sim.servicosprefeituras.utils.Constantes;
import br.gov.sp.prodesp.sim.servicosprefeituras.utils.DataUtil;
import br.gov.sp.prodesp.sim.servicosprefeituras.utils.FileUtil;

import static br.gov.sp.prodesp.sim.servicosprefeituras.utils.Constantes.PERMISSION_ALL;

public class IndicacaoCondutorActivity extends AppCompatActivity {

    private int CAMERA_REQUEST;
    private String caminhoFoto;
    private ImageView imagemCNH;
    private TextView tvTirarFoto;
    private ImageButton buttonTiraFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicacao_condutor);

        imagemCNH = findViewById(R.id.activity_indicacao_condutor_imagem_cnh);
        tvTirarFoto = findViewById(R.id.activity_indicacao_condutor_foto_cnh);

        buttonTiraFoto = findViewById(R.id.activity_indicacao_condutor_botao_tira_foto_cnh);
        buttonTiraFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CAMERA_REQUEST = Constantes.CAMERA_REQUEST_FOTO_1;
                getPermissionToCamera();
            }
        });

        Button buttonOK = findViewById(R.id.activity_indicacao_condutor_btn_ok);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getPermissionToCamera() {
        String[] permissions = AppUtils.getPermission(IndicacaoCondutorActivity.this);
        if (AppUtils.hasPermissions(IndicacaoCondutorActivity.this, permissions)) {
            openCamera(CAMERA_REQUEST);
        } else {
            AppUtils.requestPermission(IndicacaoCondutorActivity.this, permissions, PERMISSION_ALL);
        }
    }

    private void openCamera(int cameraRequestFoto) {
        Intent pictureActionIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        caminhoFoto = getExternalFilesDir(null) + "/ServicosPrefeituras" + DataUtil.dateToString(new Date(), "ddMMyyyyHHmmss") + ".jpg";
        File arquivoFoto = new File(caminhoFoto);
        pictureActionIntent.putExtra(MediaStore.EXTRA_OUTPUT, FileUtil.getUri(getApplicationContext(), arquivoFoto));
        startActivityForResult(pictureActionIntent, cameraRequestFoto);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean grantPermissions = true;
        for (int results : grantResults) {
            if (results == PackageManager.PERMISSION_DENIED) {
                grantPermissions = false;
            }
        }
        if (grantPermissions) {
            openCamera(CAMERA_REQUEST);
        } else {
            Alert.mostrarDialogSimples(getResources().getString(R.string.seguranca_acesso_permissao_camera),
                    IndicacaoCondutorActivity.this);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            procesarResult(requestCode, resultCode);
        } finally {
            FileUtil.removeFileFrom(caminhoFoto);
        }
    }

    private void procesarResult(int requestCode, int resultCode) {
        if (resultCode == RESULT_OK) {
            if (requestCode == Constantes.CAMERA_REQUEST_FOTO_1) {
                try {
                    String nomeArquivo = CameraUtils.armazenarFoto(caminhoFoto, Constantes.chaveCriptografia);
                    byte bytesImagem[] = FileUtil.decryptFile(nomeArquivo, Constantes.chaveCriptografia);
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytesImagem, 0, bytesImagem.length);
                    imagemCNH.setImageBitmap(bitmap);
                    imagemCNH.setVisibility(View.VISIBLE);
                    buttonTiraFoto.setVisibility(View.GONE);
                    tvTirarFoto.setVisibility(View.GONE);
                } catch (Exception e) {
                    buttonTiraFoto.setVisibility(View.VISIBLE);
                    tvTirarFoto.setVisibility(View.VISIBLE);
                    imagemCNH.setVisibility(View.GONE);
                }
            }
        }
    }
}
