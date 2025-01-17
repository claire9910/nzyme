import React from 'react'
import LoadingSpinner from '../misc/LoadingSpinner'
import ProbeTableRow from './ProbeTableRow'

class ProbesTable extends React.Component {
  render () {
    const self = this

    if (!this.props.probes) {
      return <LoadingSpinner/>
    } else {
      return (
                <table className="table table-sm table-hover table-striped">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Running</th>
                        <th>Class</th>
                        <th>Interface</th>
                        <th>Channels</th>
                        <th>Frames</th>
                    </tr>
                    </thead>
                    <tbody>
                        {Object.keys(this.props.probes).map(function (key, i) {
                          return <ProbeTableRow key={i} probe={self.props.probes[key]} />
                        })}
                    </tbody>
                </table>
      )
    }
  }
}

export default ProbesTable
