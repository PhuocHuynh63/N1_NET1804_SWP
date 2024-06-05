import React from 'react';
import { Swiper, SwiperSlide } from 'swiper/react';
import 'swiper/css';
import 'swiper/css/pagination';
import 'swiper/css/navigation';
import { Autoplay, Pagination, Navigation } from 'swiper/modules';
import homeApi from '~/apis/home.apis';
import { Banner, Category } from '~/types/category.type';
import { API_URL_IMAGE } from '~/constants/utils';
import './styles.css';
import { toast } from 'react-toastify';
import SwiperCore from 'swiper/core';
import categoryApi from '~/apis/category.apis';
import { Link, useNavigate } from 'react-router-dom';
import productApi from '~/apis/product.apis';
import { Product } from '~/types/product.type';
// import ItemProduct from '~/components/product';
import { Sale } from '~/types/sale.type';
import saleApi from '~/apis/sale.apis';
import { formatDateString } from '~/constants/formatDate';
import path from '~/constants/path';

SwiperCore.use([Navigation]);
const Home = () => {
  const navigate = useNavigate();
  const [slide, setSlide] = React.useState<Banner[]>([]);
  const [productBestSeller, setProductBestSeller] = React.useState<Product[]>([]);
  //PBS === productBestSeller
  const [sales, setSales] = React.useState<Sale[]>([]);
  const [salesColection, setSalesColection] = React.useState<Sale[]>([]);
  const [salesProduct, setSalesProduct] = React.useState<Sale[]>([]);

  const getSlideHome = async () => {
    try {
      const res = await homeApi.getSlideHome();
      if (res.data.status) {
        setSlide(res.data.data);
      } else {
        toast.error(`${res.data.data}`, {
          position: 'top-right',
          pauseOnHover: false,
          theme: 'dark',
        });
      }
    } catch (error) {
      console.error(error);
    }
  };
  React.useEffect(() => {
    getSlideHome();
  }, []);
  //getcategory
  const [category1, setCategory1] = React.useState<Category[]>([]);

  const [category2, setCategory2] = React.useState<Category[]>([]);
  const getCategory = async (id: number) => {
    try {
      const res = await categoryApi.getCategoryParent(id);
      if (res.data.status) {
        const category = res.data.data;
        if (id === 28) {
          setCategory1(category);
        } else if (id === 29) {
          setCategory2(category);
        }
      }
    } catch (error) {
      console.error(error);
    }
  };
  const category: Category[] = [...category1, ...category2];

  React.useEffect(() => {
    getCategory(28);
    getCategory(29);
  }, []);
  
  //getProductBestSeller
  const getProBestSeller = async () => {
    try {
      const res = await productApi.getBestSellerProduct();
      if (res.data.status) {
        const productBestSeller = res.data.data.data;
        setProductBestSeller(productBestSeller);
      } else {
        toast.error(`${res.data.data.data}`, {
          position: 'top-right',
          pauseOnHover: false,
          theme: 'dark',
        });
      }
    } catch (error) {
      console.error(error);
    }
  };
  React.useEffect(() => {
    getProBestSeller();
  }, []);
  const getSale = async (id: number) => {
    try {
      const res = await saleApi.getSale(id);
      if (res.data.status) {
        const sale = res.data.data;
        setSales((prevMapping) => ({
          ...prevMapping,
          [sale.id]: sale.discount,
        }));
        setSalesColection((prevMapping) => ({
          ...prevMapping,
          [sale.id]: sale.discount,
        }));
        setSalesProduct((prevMapping) => ({
          ...prevMapping,
          [sale.id]: sale.discount,
        }));
      } else {
        toast.error(`${res.data.data}`, {
          position: 'top-right',
          pauseOnHover: false,
          theme: 'dark',
        });
      }
    } catch (error) {
      console.error(error);
    }
  };
  React.useEffect(() => {
    if (productBestSeller.length > 0) {
      productBestSeller.forEach(async (item) => {
        if (item.sale != null && item.sale !== 0) {
          await getSale(item.sale);
        }
      });
    }
  }, [productBestSeller]);
  //productColection
  const [activeTab, setActiveTab] = React.useState<number | null>();
  const [activeCategoryId, setActiveCategoryId] = React.useState<number | null>(null);
  React.useEffect(() => {
    if (category.length > 0) {
      if (activeCategoryId === null || !category.find((item) => item.id === activeCategoryId)) {
        setActiveCategoryId(1);
      }
    }
  }, [category]);

  React.useEffect(() => {
    if (activeCategoryId !== null) {
      setActiveTab(activeCategoryId);
    }
  }, [activeCategoryId]);

  const handleTabClick = (tabIndex) => {
    setActiveCategoryId(tabIndex);
  };
  const [productColection, setProductColection] = React.useState<Product[]>([]);
  const getProduct = async (id: number) => {
    try {
      const res = await productApi.getProductByCategory(id);
      if (res.data.status) {
        setProductColection(res.data.data);
      } else {
        setProductColection([]);
      }
    } catch (error) {
      console.error(error);
    }
  };
  React.useEffect(() => {
    if (!!activeTab) {
      getProduct(activeTab);
    }
  }, [activeTab]);
  React.useEffect(() => {
    if (productColection.length > 0) {
      productColection.forEach(async (item) => {
        if (item.sale != null && item.sale !== 0) {
          await getSale(item.sale);
        }
      });
    }
  }, [productColection]);
  
  //đếm ngược
  const [countdown, setCountdown] = React.useState({
    days: 0,
    hours: 0,
    minutes: 0,
    seconds: 0,
  });
  let countdownInterval;
  React.useEffect(() => {
    const targetDate = new Date('2023-12-24T10:00:00').getTime();
    const calculateCountdown = () => {
      const now = new Date().getTime();
      const timeDifference = targetDate - now;

      if (timeDifference <= 0) {
        // Countdown has ended
        clearInterval(countdownInterval);
        setCountdown({
          days: 0,
          hours: 0,
          minutes: 0,
          seconds: 0,
        });
      } else {
        const days = Math.floor(timeDifference / (1000 * 60 * 60 * 24));
        const hours = Math.floor((timeDifference % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        const minutes = Math.floor((timeDifference % (1000 * 60 * 60)) / (1000 * 60));
        const seconds = Math.floor((timeDifference % (1000 * 60)) / 1000);

        setCountdown({ days, hours, minutes, seconds });
      }
    };

    countdownInterval = setInterval(calculateCountdown, 1000);

    return () => {
      clearInterval(countdownInterval);
    };
  }, []);
  
  return (
    <>
      {/* gần cuối */}
      <div className="section-home-policy">
        <div className="container">
          <div className="list-policy-row row">
            <div className="col-xl-3 col-lg-6 col-md-6 col-12 policy-item">
              <div className="policy-item__inner">
                <div className="policy-item__icon">
                  <div className="icon">
                    <img
                      className=" lazyloaded"
                      data-src="//theme.hstatic.net/200000000133/1001115658/14/home_policy_icon_1.png?v=275"
                      src="//theme.hstatic.net/200000000133/1001115658/14/home_policy_icon_1.png?v=275"
                      alt="Freeship"
                    />
                  </div>
                </div>
                <div className="policy-item__info">
                  <h3 className="info-title">Free ship</h3>
                  <div className="infor-des">Free ship from xxx</div>
                </div>
              </div>
            </div>
            <div className="col-xl-3 col-lg-6 col-md-6 col-12 policy-item">
              <div className="policy-item__inner">
                <div className="policy-item__icon">
                  <div className="icon">
                    <img
                      className=" lazyloaded"
                      data-src="//theme.hstatic.net/200000000133/1001115658/14/home_policy_icon_2.png?v=275"
                      src="//theme.hstatic.net/200000000133/1001115658/14/home_policy_icon_2.png?v=275"
                      alt="Free exchange fee"
                    />
                  </div>
                </div>
                <div className="policy-item__info">
                  <h3 className="info-title">Free exchange fee</h3>
                  <div className="infor-des">Return the goods after 7 days if you are not satisfied</div>
                </div>
              </div>
            </div>
            <div className="col-xl-3 col-lg-6 col-md-6 col-12 policy-item">
              <div className="policy-item__inner">
                <div className="policy-item__icon">
                  <div className="icon">
                    <img
                      className=" lazyloaded"
                      data-src="//theme.hstatic.net/200000000133/1001115658/14/home_policy_icon_3.png?v=275"
                      src="//theme.hstatic.net/200000000133/1001115658/14/home_policy_icon_3.png?v=275"
                      alt="G3NET1804"
                    />
                  </div>
                </div>
                <div className="policy-item__info">
                  <h3 className="info-title">G3NET1804</h3>
                  <div className="infor-des">
                    Call <b>G3NET1804</b> 
                  </div>
                </div>
              </div>
            </div>
            <div className="col-xl-3 col-lg-6 col-md-6 col-12 policy-item">
              <div className="policy-item__inner">
                <div className="policy-item__icon">
                  <div className="icon">
                    <img
                      className=" lazyloaded"
                      data-src="//theme.hstatic.net/200000000133/1001115658/14/home_policy_icon_4.png?v=275"
                      src="//theme.hstatic.net/200000000133/1001115658/14/home_policy_icon_4.png?v=275"
                      alt="Diverse payments"
                    />
                  </div>
                </div>
                <div className="policy-item__info">
                  <h3 className="info-title">Diverse payments</h3>
                  <div className="infor-des">Diverse payment methods</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Home;
