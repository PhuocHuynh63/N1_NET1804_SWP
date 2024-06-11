import React, { useState } from "react";
import "./Header.css";
import LoginPage from "../../pages/loginPage/LoginPage";

export default function Header() {
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    return (
        <div className="header_container">
            <header>
                <a className="navbar_brand" href="/"><img src="/images/Logo_Header_RemoveBackground.png" alt="Nous Logo" height="50" /></a>

                <form className="form_inline">
                    <input className="form_control" type="search" placeholder="Nhập tên sản phẩm" aria-label="Search" />
                    <i id="search" className="fa-solid fa-magnifying-glass"></i>
                </form>

                <div className="icons">
                    <span className="icons-header" onClick={handleShow}>
                        <i className="fa-regular fa-user"></i>
                    </span>
                    <a className="icons-header" href="/cart">
                        <i className="fa-solid fa-cart-shopping"></i>
                    </a>
                </div>
            </header>

            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav">
                        <li className="nav-item active">
                            <a className="nav-link" href="/about">Giới Thiệu MeBe</a>
                        </li>
                        <li className="nav-item dropdown">
                            <a className="nav-link dropdown-toggle" href="#" id="navbarDropdown1" role="button" aria-haspopup="true" aria-expanded="false">
                                Sữa & Bình Sữa
                            </a>
                            <div className="dropdown-menu" aria-labelledby="navbarDropdown1">
                                <a className="dropdown-item_title" href="/newborn-0-3">Sữa</a>
                                <a className="dropdown-item" href="/newborn-0-3">Sữa bột</a>
                                <a className="dropdown-item" href="/baby-3-24">Sữa pha sẵn</a>
                                <div className="dropdown-divider"></div>
                                <a className="dropdown-item_title" href="#">Bình sữa - Núm ti - Phụ kiện</a>
                                <a className="dropdown-item" href="#">Bình sữa</a>
                                <a className="dropdown-item" href="#">Phụ kiện bình sữa</a>
                                <a className="dropdown-item" href="#">Núm ti</a>
                                <a className="dropdown-item" href="#">Núm ti thay thế</a>
                            </div>
                        </li>
                        <li className="nav-item dropdown">
                            <a className="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" aria-haspopup="true" aria-expanded="false">
                                Đồ Cho Mẹ
                            </a>
                            <div className="dropdown-menu" aria-labelledby="navbarDropdown2">
                                <a className="dropdown-item" href="/boys-0-3">Sơ sinh 0-3 tháng</a>
                                <a className="dropdown-item" href="/boys-3-24">Bé 3-24 tháng</a>
                                <div className="dropdown-divider"></div>
                                <a className="dropdown-item" href="#">Something else here</a>
                            </div>
                        </li>
                        <li className="nav-item dropdown">
                            <a className="nav-link dropdown-toggle" href="#" id="navbarDropdown3" role="button" aria-haspopup="true" aria-expanded="false">
                                Thời Trang Bé Gái
                            </a>
                            <div className="dropdown-menu" aria-labelledby="navbarDropdown3">
                                <a className="dropdown-item" href="/girls-0-3">Sơ sinh 0-3 tháng</a>
                                <a className="dropdown-item" href="/girls-3-24">Bé 3-24 tháng</a>
                                <div className="dropdown-divider"></div>
                                <a className="dropdown-item" href="#">Something else here</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>

            <LoginPage show={show} handleClose={handleClose} />
        </div>
    );
}
