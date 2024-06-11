import React, { useState, useEffect } from 'react';
import { useParams, Link } from 'react-router-dom';
import './Category.css';

const categories = {
    "Sữa & Bình Sữa": [
        { name: "Sữa bột", img: "/images/suabot.png" },
        { name: "Sữa pha sẵn", img: "/images/suahop.png" },
        { name: "Bình sữa", img: "/images/binhsua.png" },
        { name: "Phụ kiện", img: "/images/phukien.png" },
        { name: "Núm ti", img: "/images/numti.png" },
        { name: "Khác", img: "/images/other.png" }
    ],
    "Đồ Cho Mẹ": [
        { name: "Thời trang", img: "/icons/Thời trang.png" },
        { name: "Áo", img: "/icons/Áo.png" },
        { name: "Quần", img: "/icons/Quần.png" },
        { name: "Váy", img: "/icons/Váy.png" },
        { name: "Phụ kiện", img: "/icons/Phụ kiện.png" },
        { name: "Túi xách", img: "/icons/Túi xách.png" },
        { name: "Giày dép", img: "/icons/Giày dép.png" }
    ],
    "Thời Trang Cho Bé": [
        { name: "Quần áo", img: "/icons/Bộ body.png" },
        { name: "Balo - Túi xách", img: "/icons/Bộ dài tay.png" },
        { name: "Giày dép", img: "/icons/Bộ cộc tay.png" },
        { name: "Đồ bơi", img: "/icons/Bộ yếm.png" },
        { name: "Khác", img: "/icons/Bộ yếm.png" }
    ]
};

const products = {
    "Sữa bột": [
        { name: "Sản phẩm 1", img: "https://bom.so/EHGz7s", price: "100.000 VND" },
        { name: "Sản phẩm 2", img: "https://bom.so/KxNn56", price: "200.000 VND" },
        { name: "Sản phẩm 3", img: "https://bom.so/1Pvz8m", price: "300.000 VND" },
        { name: "Sản phẩm 4", img: "https://bom.so/o41FuN", price: "175.000 VND" },
        { name: "Sản phẩm 5", img: "https://bom.so/dvfHrb", price: "460.000 VND" },
        { name: "Sản phẩm 6", img: "https://bom.so/W0mhOE", price: "560.000 VND" },
        { name: "Sản phẩm 7", img: "https://bom.so/i0QHjy", price: "326.000 VND" }
    ],
    "Sữa pha sẵn": [
        { name: "Sản phẩm 8", img: "/images/sample-product4.png", price: "150.000 VND" },
        { name: "Sản phẩm 9", img: "/images/sample-product5.png", price: "250.000 VND" }
    ],
    
    "Quần áo": [
        { name: "Sản phẩm 1", img: "", price: "100.000 VND" },
        { name: "Sản phẩm 2", img: "", price: "200.000 VND" },
        { name: "Sản phẩm 3", img: "", price: "300.000 VND" },
        { name: "Sản phẩm 4", img: "", price: "175.000 VND" },
        { name: "Sản phẩm 5", img: "", price: "460.000 VND" },
        { name: "Sản phẩm 6", img: "", price: "560.000 VND" },
        { name: "Sản phẩm 7", img: "", price: "326.000 VND" }
    ],

    "Balo - Túi xách": [
        { name: "Sản phẩm 1", img: "", price: "200.000 VND" },
        { name: "Sản phẩm 2", img: "", price: "560.000 VND" },
        { name: "Sản phẩm 3", img: "", price: "200.000 VND" },
        { name: "Sản phẩm 4", img: "", price: "175.000 VND" },
        { name: "Sản phẩm 5", img: "", price: "632.000 VND" },
        { name: "Sản phẩm 6", img: "", price: "213.000 VND" },
        { name: "Sản phẩm 7", img: "", price: "326.000 VND" }
    ],
};

export default function Category() {
    const { category } = useParams();
    const [subcategories, setSubcategories] = useState([]);
    const [productData, setProductData] = useState({});
    const [scrollIndices, setScrollIndices] = useState({});

    useEffect(() => {
        setSubcategories(categories[category] || []);
        const initialProductData = {};
        const initialScrollIndices = {};
        categories[category].forEach(sub => {
            initialProductData[sub.name] = products[sub.name] || [];
            initialScrollIndices[sub.name] = 0;
        });
        setProductData(initialProductData);
        setScrollIndices(initialScrollIndices);
    }, [category]);

    const handleScrollLeft = (subcategory) => {
        setScrollIndices(prevIndices => ({
            ...prevIndices,
            [subcategory]: Math.max(prevIndices[subcategory] - 1, 0)
        }));
    };

    const handleScrollRight = (subcategory) => {
        setScrollIndices(prevIndices => ({
            ...prevIndices,
            [subcategory]: Math.min(prevIndices[subcategory] + 1, (productData[subcategory]?.length || 0) - 5)
        }));
    };

    return (
        <div className="category-main">

                <h1>Bạn muốn tìm gì?</h1>
            <div className="subcategory-selector">
                
                <div className="subcategory-list">
                    {subcategories.map(sub => (
                        <div className="subcategory-item" key={sub.name}>
                            <Link to={`/category/${category}/${sub.name}`}>
                                <div className="subcategory-content">
                                    <img src={sub.img} alt={sub.name} />
                                    <p>{sub.name}</p>
                                </div>
                            </Link>
                        </div>
                    ))}
                </div>
            </div>
            {subcategories.map(sub => (
                <div key={sub.name} className="product-section">
                    <h2>{sub.name}</h2>
                    <div className="product-list-container">
                        <button className="nav-button left" onClick={() => handleScrollLeft(sub.name)}>{'<'}</button>
                        <div className="product-list">
                            {(productData[sub.name] || []).slice(scrollIndices[sub.name], scrollIndices[sub.name] + 5).map(product => (
                                <div className="product-item" key={product.name}>
                                    <img src={product.img} alt={product.name} />
                                    <div className="product-info">
                                        <p className="product-name">{product.name}</p>
                                        <p className="product-price">{product.price}</p>
                                    </div>
                                </div>
                            ))}
                        </div>
                        <button className="nav-button right" onClick={() => handleScrollRight(sub.name)}>{'>'}</button>
                    </div>
                </div>
            ))}
        </div>
    );
}
