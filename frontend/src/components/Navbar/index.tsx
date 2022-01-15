// Considera o path a partir da pasta src
// Precisa configurar o baseURL em tsconfig para fazer isso
import { ReactComponent as GithubIcon } from 'assets/img/github.svg'

import './styles.css'

function Navbar() {
    return (
        <header>
            <nav className="container">
                <div className="dsmovie-nav-content">
                    <h1>DSMovie</h1>
                    <a href="https://github.com/rodrigoCodDev">
                        <div className="dsmovie-nav-content">
                            <GithubIcon />
                            <p className="dsmovie-contact-link">/rodrigoCodDev</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    )
}

export default Navbar;