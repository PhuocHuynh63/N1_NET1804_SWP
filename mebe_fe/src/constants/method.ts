/* eslint-disable @typescript-eslint/no-explicit-any */
import axios from 'axios';
import { API_URL } from './utils';
import { useSelector } from 'react-redux';

interface IProps {
  url: string;
  method: string;
  data?: any;
  token?: any;
}

const REQUEST_API = async ({ method, url, data, token }: IProps) => {
    
    const headers = {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
    };

    const config = { method, url, data, headers };

    try {
        const res = await axios(config);
        if (res.status === 200) {
            return res.data;
        }
    } catch (e) {
            throw new Error();
        }
};

export {REQUEST_API};