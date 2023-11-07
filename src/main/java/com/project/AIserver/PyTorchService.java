package com.project.AIserver;

/*import java.io.IOException;
import org.pytorch.IValue;
import org.pytorch.Module;
import org.pytorch.Tensor;
public class PyTorchService
{
    private Module module;

    public PyTorchService()
    {
        try(InputStream is = getClass().getResourceAsStream("/epoch_8.pth"))
        {
            module = Module.load(is);
        } catch (IOException e)
        {
            throw new RuntimeException("모델 파일을 불러올 수 없습니다.", e);
        }
    }

    //입력 데이터를 사용하여 AI 모델을 실행하고 결과를 반환한다.
    public float[] predict(float[] inputData)
    {
        Tensor input = Tensor.fromBlob(inputData, new long[]{1, inputData.length});
        Tensor output = module.forward(IValue.from(input)).toTensor();
        float[] result = output.getDataAsFloatArray();
        return result;
    }
}*/
