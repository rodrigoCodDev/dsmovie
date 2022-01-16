import FormCard from 'components/FormCard';
import { useParams } from 'react-router-dom';



function Form(): any {

    // Pega o parâmetro da requisição e passa para o FormCard
    const params = useParams()

    return (
        <FormCard movieId={`${params.movieId}`} />
    );
}

export default Form;