import React from "react";
import numeral from 'numeral'
import moment from "moment";

function TapsRow(props) {

    const tap = props.tap;

    return (
        <tr>
            <td>{tap.name}</td>
            <td>{numeral(tap.processed_bytes_10/10).format('0 b')}/sec</td>
            <td>{numeral(tap.processed_bytes_total).format('0 b')}</td>
            <td>{numeral(tap.cpu_load).format('0.0')}%</td>
            <td>
                {numeral(tap.memory_used).format('0 b')} / {numeral(tap.memory_total).format('0 b')} ({numeral(tap.memory_used/tap.memory_total*100).format('0.0')}%)
            </td>
            <td title={moment(tap.updated_at).format()}>
                {moment(tap.updated_at).fromNow()}
            </td>
        </tr>
    )

}

export default TapsRow;