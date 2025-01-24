
import axios from 'axios';

export const axiosInstance = axios.create({
  baseURL: 'http://localhost:8081/api', // Backend base URL
  headers: {
    'Content-Type': 'application/json',
  },
});
